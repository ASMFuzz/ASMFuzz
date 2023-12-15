import os
import traceback
from tqdm import tqdm
from bs4 import BeautifulSoup

script_dir = os.path.dirname(os.path.abspath(__file__))
AllClasses = os.path.join(script_dir, 'AllClasses.html')

def get_all_class_page():
    """New version.Change the way to get all class page"""
    all_classes_page = []
    print(os.getcwd())
    soup_all = BeautifulSoup(open(AllClasses, encoding='utf-8'), features='html.parser')
    a_tag_list = soup_all.find_all('a')
    for a_tag in a_tag_list:
        try:
            all_classes_page.append(a_tag['href'])
        except:
            tqdm.write("no attr named 'href'")
    return all_classes_page


def get_all_classes():
    """Old version."""

    all_classes_page = {}
    soup_all = BeautifulSoup(open(AllClasses, encoding='utf-8'), features='html.parser')
    a_tag_list = soup_all.find_all('a')
    for a_tag in a_tag_list:
        try:
            all_classes_page[a_tag['href']] = a_tag.string
        except:
            tqdm.write("no attr named 'href'")
    return all_classes_page


def get_all_files(path):
    all_files = []
    for root, dirs, files in os.walk(path):
        for file in files:
            all_files.append(os.path.join(root, file))
    return all_files


def read_local_file(path):
    """get all content from one class page."""

    tqdm.write("Now visit page:" + path)
    class_path = path
    try:
        f = open(class_path, 'r', encoding='utf-8')
        one_class_text = f.read()
        if f:
            f.close()
    except:
        # traceback.print_exc()
        tqdm.write(traceback.format_exc())
        return ""
    return one_class_text


def get_soup(one_class_text: str) -> BeautifulSoup:
    """Get soup from general content."""

    soup = BeautifulSoup(one_class_text, features='html.parser')
    return soup


def get_needful_block(soup, one_class_text, start_string, end_string):
    """Use start_string and end_string to get the needful block from one class page."""

    # Check if this is an interface page.
    if is_interface_page(soup.h2.get_text()):
        return ""
    # Cut off the part we need.
    start_index = one_class_text.find(start_string)
    # print(start_index)
    if (start_index == -1):
        tqdm.write("can't find needful block")
        return ""
    end_index = one_class_text.find(end_string)
    # print("index:"+str(start_index)+" "+str(end_index))
    constructor_content = one_class_text[start_index:end_index]
    # print("==constructor content:\n"+constructor_content)

    return constructor_content


def is_interface_page(title):
    return title.find("Interface ") != -1
