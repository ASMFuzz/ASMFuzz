import re
import json
import logging
import traceback
from tqdm import tqdm
from bs4 import BeautifulSoup

from parse_javadoc import get_all_class_page, get_needful_block, read_local_file, get_soup
from db_operation_base import DataBaseHandle

boundary_keyword_list = [">", "<", "=", "!", "less than", "greater than", "equal to", "null"]
import os

script_dir = os.path.dirname(os.path.abspath(__file__))
logfile = os.path.join(script_dir, '03error_method.log')

class MethodInfo:
    def __init__(self, class_name, method_name, param_info, boundary_value, return_type, throws_desc, import_stmt,
                 class_page):
        self.class_name = class_name
        self.method_name = method_name
        self.param_info = param_info
        self.boundary_value = boundary_value
        self.return_type = return_type
        self.throws_desc = throws_desc
        self.import_stmt = import_stmt
        self.class_page = class_page

    def format_output(self):
        format_info = [self.class_name, self.method_name, json.dumps(self.param_info), json.dumps(self.boundary_value),
                       self.return_type, self.throws_desc, self.import_stmt, self.class_page]
        return format_info


def get_param_info(param_sentence: str):
    tqdm.write("param sentence:" + param_sentence)
    param_array = re.split(", |,", param_sentence)
    # print(param_array)
    param_info_dict = {}
    param_list = []
    for param in param_array:
        space_index = param.find(" ")
        param_type = param[:space_index]
        param_name = param[space_index + 1:]
        param_info_dict[param_name] = param_type
        param_list.append(param_name)
    return param_list, param_info_dict


def get_method_info(pre_tag, class_page):
    method_dec_str = pre_tag.get_text().replace("\n", "").replace("  ", "").replace("\xa0", " ")
    tqdm.write("pre_tag_text:" + method_dec_str)
    regex = r"(.*?)(public |final |protected |abstract |static )([\w.\[\]<>]+) (\w+)\((.*?)\)( *throws (.*))*"
    matches = re.finditer(regex, method_dec_str, re.MULTILINE)
    return_type, method_name, param_sentence, throws_description, all_import_stmt = "", "", "", "", ""
    for matchNum, match in enumerate(matches, start=1):
        return_type = match.group(3)
        method_name = match.group(4)
        param_sentence = match.group(5)
        if len(match.groups()) == 7:
            throws_description = match.group(7)
    a_tag_list = pre_tag.find_all("a")
    for a_tag in a_tag_list:
        if (a_tag.string in param_sentence) & (a_tag.string != "String"):
            tqdm.write("a_tag:" + a_tag.string + " a_tag_title:" + a_tag.get("title"))
            a_tag_title = a_tag['title']
            one_import_stmt = "import " + a_tag_title[a_tag_title.rfind(" ") + 1:] + "." + a_tag.string + ";\n"
            if one_import_stmt not in all_import_stmt:
                all_import_stmt += one_import_stmt
    tqdm.write("import_stmt:" + all_import_stmt)
    param_list, param_info_dict = get_param_info(param_sentence)
    # print("param info:",param_info_dict)
    # Get boundary value dictory.
    boundary_value_dict = {}
    if (len(param_list) > 0) & (li_tag.dl is not None):
        dt_tag_list = li_tag.dl.find_all('dt')
        for dt_tag in dt_tag_list:
            if (dt_tag.string == "Parameters:") | (dt_tag.string == "Throws:"):
                boundary_value_dict = get_boundary_value(param_list, dt_tag)
                tqdm.write("boundary value:" + str(boundary_value_dict))
    return MethodInfo(class_name, method_name, param_info_dict, boundary_value_dict, return_type, throws_description,
                      all_import_stmt, class_page)


def contain_boundary_keyword(description):
    if any(keyword in description for keyword in boundary_keyword_list):
        return True
    return False


def get_contained_parameter(param_list, description):
    """If sentence refer to parameter, return parameter list."""

    contained_param_list = []
    for param in param_list:
        if param in description:
            contained_param_list.append(param)
    return contained_param_list


def spilt_description(description):
    """ Get sentence formated such as 'if xxx is xxx'."""

    sentence_array = []
    # if "." in description:
    #     sentence_array = description.split(".")
    # elif "\n" in description:
    #     sentence_array = description.split("\n")
    sentence_array = re.split("\n| or ", description)
    for i in range(len(sentence_array)):
        if sentence_array[i] == "":
            sentence_array[i] = sentence_array[i - 1]
        elif " - " in description:
            sentence_array[i] = sentence_array[i][sentence_array[i].find(" - ") + 3:]
    return sentence_array


def process_description(param_list, description):
    """Use parameters and description to get boundary value dictory."""

    boundary_value_dict = {}
    sentence_array = spilt_description(description)
    for sentence in sentence_array:
        if contain_boundary_keyword(sentence):
            boundary_value = sentence[sentence.find("is") + 3:]
            contained_param_list = get_contained_parameter(param_list, sentence)
            for contained_param in contained_param_list:
                boundary_value_dict[contained_param] = boundary_value
    return boundary_value_dict


def get_boundary_value(param_list, dt_tag):
    """Get description from Parameters and Thorws,then get boundary value."""

    boundary_value_dict = {}
    # print("dt tag:",dt_tag)
    all_siblings = dt_tag.next_siblings
    # print("siblings size:",sum(1 for _ in all_siblings))
    for sibling in all_siblings:
        # print("lable name:",sibling.name)
        if sibling.name == "dd":
            description = sibling.get_text()
            if contain_boundary_keyword(description):
                # print("code:",sibling.code.string," string:",description)
                boundary_value_dict = process_description(param_list, description)
        elif sibling.name == "dt":
            break
    return boundary_value_dict


if __name__ == '__main__':
    logging.basicConfig(filename=logfile, filemode='w', level=logging.DEBUG)
    interface_count, method_count = 0, 0
    method_info_list = []
    start_string = "<!-- ============ METHOD DETAIL ========== -->"
    end_string = "<!-- ========= END OF CLASS DATA ========= -->"

    all_class_page = get_all_class_page()
    # all_class_page = ["https://docs.oracle.com/javase/8/docs/api/javax/swing/plaf/nimbus/AbstractRegionPainter.html"]
    # all_class_page = ["https://docs.oracle.com/javase/8/docs/api/java/io/File.html"]

    pbar = tqdm(total=len(all_class_page))

    try:
        for one_class_page in all_class_page:
            pbar.update(1)
            class_name = one_class_page[one_class_page.rindex("/") + 1:one_class_page.find(".html")]
            tqdm.write("class name:" + class_name)
            url = "/root/shannonfuzz-python/ParseAPI/javadoc" + one_class_page[one_class_page.find("/docs/"):]
            one_class_context = read_local_file(url)
            if one_class_context == "":
                continue
            soup_all = get_soup(one_class_context)
            method_detail = get_needful_block(soup_all, one_class_context, start_string, end_string)
            if method_detail == "":
                interface_count += 1
                continue
            soup_method = get_soup(method_detail)
            li_tag_list = soup_method.find_all("li")
            tqdm.write("li tag size:" + str(len(li_tag_list)))
            for i in range(1, len(li_tag_list)):
                li_tag = li_tag_list[i]
                if li_tag.h4 == None:
                    continue
                # Get method name.
                method_name = li_tag.h4.string
                print("method name:" + method_name)
                # Get return type.
                method_dec_str = li_tag.pre.get_text().replace("\n", "").replace("  ", "").replace("\xa0", " ")
                print(method_dec_str)
                type_end_index = method_dec_str.rfind(" ", 0, method_dec_str.find("("))
                type_start_index = method_dec_str.rfind(" ", 0, type_end_index - 1)
                return_type = method_dec_str[type_start_index + 1:type_end_index]
                print("return type:", return_type)
                method_info = get_method_info(li_tag.pre, one_class_page)
                # print(li_tag.h4)
                formative_method_info = method_info.format_output()
                method_info_list.append(formative_method_info)
                method_count += 1
    except Exception as e:
        print(e)
        tqdm.write("Error occured.")
        logging.info(one_class_page+"\n"+traceback.format_exc()+"\n")
    else:
        db_handler = DataBaseHandle()
        sql = 'insert into Method_Info(Class_Name,Method_Name,Param_Info,Boundary_Value,Return_Type,Throws_Desc,Import_Stmt,Class_Page) values(%s,%s,%s,%s,%s,%s,%s,%s)'
        db_handler.insertMany(sql, method_info_list)
        tqdm.write("interface count:" + str(interface_count) + " method count:" + str(method_count))
