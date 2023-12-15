import re
import traceback
import logging

from typing import List
from tqdm import tqdm
from bs4 import BeautifulSoup

# from db_operation_needful import insert_many_data_into_table
from db_operation_base import DataBaseHandle
from parse_javadoc import get_needful_block, get_soup, read_local_file, get_all_class_page
import os

script_dir = os.path.dirname(os.path.abspath(__file__))
logfile = os.path.join(script_dir, '01error_API.log')

class API_Info:
    """all classes information"""

    def __init__(self, Class_Name: str, Constructor_Stmt: str, Class_URL: str):
        self.Class_Name = Class_Name
        self.Constructor_Stmt = Constructor_Stmt
        self.Class_URL = Class_URL

    def format_output(self) -> List[str]:
        format_info = [self.Class_Name, self.Constructor_Stmt, self.Class_URL]
        # print(format_info)
        return format_info

def get_param_type(pre_tag_text: str, class_name: str) -> str:
    regex = r"([\w\[\]<>? ]+) (\w+)"
    constructor_stmt = class_name + "("
    index_left = pre_tag_text.find('(')
    index_right = pre_tag_text.find(')')
    if (index_right == index_left + 1):
        constructor_stmt += ");\n"
        return constructor_stmt
    param_stmt = pre_tag_text[index_left + 1:index_right]
    tqdm.write("param stmt:" + param_stmt)
    param_list = param_stmt.split(',')
    for param in param_list:
        tqdm.write("param:" + param)
        matches = re.finditer(regex, param, re.MULTILINE)
        for matchNum, match in enumerate(matches, start=1):
            constructor_stmt += match.group(1) + ","
    return constructor_stmt[:-1] + ");\n"


def get_constructor_stmt(content: str, class_name: str) -> str:
    """if all type can be generated,add this constructor"""

    all_constructor_stmt = ""
    soup_one = BeautifulSoup(content, 'html.parser', from_encoding='utf-8')
    # pre_tag_list = soup_one.find_all('pre')
    # for pre_tag in pre_tag_list:
    title_list = soup_one.find_all('h4')
    for (index, title) in enumerate(title_list):
        pre_tag = title.find_next_sibling('pre')
        # print(str(index)+":\n"+pre_tag.get_text())
        a_tag_list_of_pre = pre_tag.find_all('a')
        pre_tag_text = pre_tag.get_text()
        # print("pre tag:"+pre_tag_text)
        constructor_stmt = get_param_type(pre_tag_text, class_name)
        all_constructor_stmt += constructor_stmt
    # all_constructor_stmt.replace(",  ",", ")
    tqdm.write("check all constructor:\n" + all_constructor_stmt)
    return all_constructor_stmt

if __name__ == '__main__':
    logging.basicConfig(filename=logfile, filemode='w', level=logging.DEBUG)
    start_string = "<!-- ========= CONSTRUCTOR DETAIL ======== -->"
    end_string = "<!-- ============ METHOD DETAIL ========== -->"
    success_num, can_not_generate_num, fail_get_block_num, index = 0, 0, 0, 0
    class_path = ""
    all_format_input = []
    all_classes_info = get_all_class_page()
    # all_classes_info = ["https://docs.oracle.com/javase/8/docs/api/java/io/ByteArrayOutputStream.html"]
    try:
        pbar = tqdm(total=len(all_classes_info))
        while index < len(all_classes_info):
            # Consistent with id in database
            tqdm.write("Processing:" + str(index + 1) + "th.")
            all_constructor_info = ""
            one_class_page = all_classes_info[index]
            class_name = one_class_page[one_class_page.rindex("/") + 1:one_class_page.find(".html")]
            # class_path = "/Users/aidpaike/project/myproject/ShannonFuzz/ParseAPI/javadoc" + one_class_page[32:]
            class_path = "/root/shannonfuzz-python/ParseAPI/javadoc" + one_class_page[32:]
            one_class_text = read_local_file(class_path)
            if one_class_text == "":
                index += 1
                continue
            soup = get_soup(one_class_text)
            constructor_description = get_needful_block(soup, one_class_text, start_string, end_string)
            # If this class/interface has no constructor,or can not read.
            if constructor_description == "":
                fail_get_block_num += 1
            else:
                constructor_description = constructor_description.replace("&nbsp;", " ").replace("  ", "")
                all_constructor_info = get_constructor_stmt(constructor_description, class_name)
            if all_constructor_info == "":  # this class has no generatable constructor
                can_not_generate_num += 1
            else:
                all_format_input.append(
                    API_Info(class_name, all_constructor_info, all_classes_info[index]).format_output())
                success_num += 1
            index += 1
            pbar.update(1)
    except:
        tqdm.write("Error occured.")
        logging.info(class_path + "\n" + traceback.format_exc() + "\n")
        # print("Success:"+str(success_num)+" Fail:"+str(can_not_generate_num)+" Not class:"+str(fail_get_block_num))
        # traceback.print_exc()
    else:
        tqdm.write("Start to insert.")
        db_handler = DataBaseHandle()
        sql = "insert into API_Info(Class_Name,Constructor_Stmt,Class_URL) values(%s,%s,%s)"
        db_handler.insertMany(sql, all_format_input)
        tqdm.write("Success:" + str(success_num) + " Fail:" + str(can_not_generate_num) + " Not class:" + str(
            fail_get_block_num))
