import json
import re

import numpy as np
import matplotlib.pyplot as plt
import os,sys
from bs4 import BeautifulSoup
from concurrent.futures import ThreadPoolExecutor
from typing import List, Tuple
from matplotlib import font_manager
import matplotlib.pyplot as plt
from matplotlib_venn import venn3
from pathlib import Path
import subprocess


current_file_path = Path(__file__).resolve()
# print(current_file_path.parent.parent)
# print(type(current_file_path.parent.parent))
sys.path.append(str(current_file_path.parent.parent))

from workline.Counter import Counter
from src.studyMysql.Table_Operation import Table_Result, Table_Testcase
from bs4 import BeautifulSoup

list1 = []
file_full = {}


def test(list_id):
    table_Result = Table_Result()
    list_id = table_Result.selectAllReturncode0()
    table_testcase = Table_Testcase()
    list_testcase = []

    for i in list_id:
        testcase = table_testcase.selectOneContextFromTestcaseContent(i)
        # print(testcase)
        list_testcase.append(testcase)
        # break
    return list_testcase


def readTestcase():
    listTemp = []
    testcase = Table_Testcase()
    list2 = testcase.selectAllFromTableTestcase()
    for s in list2:
        listTemp.append(s[1])
    return listTemp


def writeFile(list_testcase):
    dict1 = {}
    str1 = 'public class '
    name = 'MyJVMTest_'
    dir = '/JVMfuzzing/wy/Comfort_all/data/seedTemp/'
    # print(len(list_testcase))
    # count=0
    for t in list_testcase:
        # count+=1
        pos1 = str(t[0]).find(str1)
        pos1 += len(str1)
        pos1 += len(name)
        pos2 = str(t[0]).find('{')
        num = str(t[0])[pos1:pos2].strip()
        file = dir + name + num + '.java'
        if file not in dict1:
            dict1[file] = 1
        else:
            dict1[file] += 1
        # print(file)
        with open(file, 'w') as f:
            f.write(str(t[0]))
    # print(count)
    return dict1


def sort_by_value(d):
    items = d.items()
    backitems = [[v[1], v[0]] for v in items]
    backitems.sort()
    return [backitems[i][1] for i in range(0, len(backitems))]


def d1():
    list_testcase = test()
    print(len(list_testcase))
    dict1 = writeFile(list_testcase)
    print("finished!")
    sort_by_value(dict1)
    for d in dict1.keys():
        print(d, ":", dict1[d])


#   reverse = False
# 	reverse = True
# 排序结果：[('a', 3), ('c', 2), ('b', 1)]
def sort_dict_by_values(d, reverse=False):
    return sorted(d.items(), key=lambda x: x[1], reverse=reverse)


# True：
# False:
def sort_dict_by_keys(d, reverse=True):
    keys = list(d.keys())
    keys.sort(reverse=reverse)
    return [(key, d[key]) for key in keys]


def writeToDB(dir, num):
    listTemp = []
    table_Testcase = Table_Testcase()
    # dir = '/JVMfuzzing/wy/Comfort_all/data/seedTemp/'
    for root, dirs, files in os.walk(dir):
        print(dir)
        for file in files:
            if not file.endswith('.java'):
                continue
            with open(dir + file, 'r') as f:
                content = f.read()
                # [Testcases_content, SourceFun_id, SourceTestcase_id, Fuzzing_times, Mutation_method,
                #                     Mutation_times, Interesting_times, Probability, Remark]
                listTemp.append(content)
    # return listTemp
    testcases_list_to_write = makeTestcasesListToWrite(listTemp, 0, 0, 0, num, 0, 0, 0, None)
    table_Testcase.insertManyDataToTableTestcase(testcases_list_to_write)


def makeTestcasesListToWrite(all_testcases, SourceFun_id, SourceTestcase_id, Fuzzing_times,
                             Mutation_method, Mutation_times, Interesting_times, Probability, Remark) -> list:
    lis = []
    for testcase in all_testcases:
        Testcases_content = testcase
        item = [Testcases_content, SourceFun_id, SourceTestcase_id, Fuzzing_times, Mutation_method,
                Mutation_times, Interesting_times, Probability, Remark]
        lis.append(item)
    return lis


def check2(testcases):
    dict1 = {}
    for s in testcases:
        temp = s.strip().split('\n')
        new_list = [i for i in temp if i != ""]
        if len(new_list) in dict1:
            dict1[len(new_list)] += 1
        else:
            dict1[len(new_list)] = 1
    return dict1


def draw(dict1, color):
    font_path = "/JVMfuzzing/wy/data/Warcraft-Font-Merger-master/merged.ttf"
    font_manager.fontManager.addfont(font_path)
    prop = font_manager.FontProperties(fname=font_path)
    plt.rcParams['font.family'] = 'sans-serif'
    plt.rcParams['font.sans-serif'] = prop.get_name()
    plt.rcParams['font.size'] = 16
    plt.rcParams['axes.unicode_minus'] = False
    plt.rcParams['ytick.direction'] = 'in'
    plt.rcParams['xtick.direction'] = 'in'
    plt.bar(list(dict1.keys()), dict1.values(), color=color, alpha=0.6)
    # font_path = '/JVMfuzzing/wy/data/SimHei.ttf'
    # my_font = font_manager.FontProperties(fname=font_path)
    fig, ax = plt.subplots(figsize=(10, 8))
    ax.spines['right'].set_visible(False)
    ax.spines['top'].set_visible(False)
    ax.set_xlabel(u'Number of lines of code.', labelpad=-120, x=1.02, fontsize=15)
    ax.set_ylabel(u'Number of files.', labelpad=-40, y=1.02, rotation=0, fontsize=15)
    plt.show()
    print("fin.")


def sumSeed():
    # list1 = writeToDB()
    list1 = readTestcase()
    print(len(list1))
    dict1 = check2(list1)
    dict2 = sort_dict_by_keys(dict1, False)
    dict_need = {}
    sum = 0
    sum2 = 0
    color = []
    for d in dict2:
        if d[0] >= 9 and d[0] < 27:
            sum += d[1]
            color.append('indigo')
        else:
            color.append('mediumpurple')
        dict_need[d[0]] = d[1]
        sum2 += d[0] * d[1]
        print(d)
    print(sum)
    print(sum * 1.0 / 563364)
    print(sum2 * 1.0 / 563364)
    draw(dict_need, color)


def dealcp(start, filepath, target):
    with open(filepath, 'r') as f:
        list1 = f.readlines()
    list2 = []
    for l in list1:
        l = start + l[1:-1]
        list2.append(l)
    str2 = ":".join(list2)
    with open(target, "w") as f:
        f.write(str2)
    return str2


def addExports(dir):
    # dir = "/root/jvm/openjdk11/jdk-11.0.17+8/test/jdk/sun/"
    list2 = dir.split('/')
    name = list2[len(list2) - 1]
    getAdd(name, dir)
    # print(list1)
    # print(len(list1))
    list2 = list1[1:]
    end = "=ALL-UNNAMED"
    # javac
    file = "/JVMfuzzing/wy/Comfort_all/data/addExports.txt"
    start = "--add-exports=java.base/"
    with open(file, "a") as f:
        for l in list2:
            print(start + l + end)
            f.write(start + l + end + "\n")

def getAdd(name, dir):
    for root, dirs, files in os.walk(dir):
        if name.__contains__("java.base"):
            continue
        if name.__contains__("META-INF"):
            continue
        if name.__contains__("%") or name.__contains__("bootstrap.linux") or name.__contains__("bootstrap.solaris"):
            continue
        if name.__contains__("8024061") or name.__contains__("8012933") or name.__contains__("4504153") \
                or name.__contains__("6409194") or name.__contains__("6550798"):
            continue
        if name.__contains__("sun.misc"):
            continue
        if name.__contains__("sun.reflect"):
            continue
        if name.__contains__("sun.security.krb5.config.native") or name.__contains__("sun.text.IntHashtable.patch-src"):
            continue
        if len(dirs) == 0:
            if not list1.__contains__(name):
                list1.append(name)
            break
        for d in dirs:
            if not list1.__contains__(name):
                list1.append(name)
            getAdd(name + "." + d, dir + '/' + d)


def delete_files_by_name(directory, filename):
    for root, dirs, files in os.walk(directory):
        for file in files:
            if file == filename:
                os.remove(os.path.join(root, file))
                print(f"{file} deleted successfully.")


def checkComm():
    com = "static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);"
    com2 = "static int[] bParam1 ="
    # dir = "/JVMfuzzing/wy/data/seed2/"
    dir = "/root/shannonfuzz-getfeature/feature/src/test/output/seed5/"
    num = 1
    count1 = 0
    files = []
    for file1 in os.listdir(dir):
        if os.path.isfile(dir + file1):
            if not file1.endswith(".java"):
                continue
            # print(file1)
            num = (int)(file1[10:-5])
            # print(num)
            # file_full[num] = 1
            with open(dir + file1, "r") as f:
                con = f.read()
                if len(con) == 0:
                    file_full[num] = 0
                    count1 += 1
                elif con.__contains__(com) and not con.__contains__(com2):
                    file_full[num] = 0
                    count1 += 1
                else:
                    file_full[num] = 1
    print(count1)


def readDB():
    dir1 = {}
    for p in file_full.keys():
        if file_full[p] == 0:
            k = "%public class MyJVMTest_" + str(p) + "%"
            obj = Table_Testcase()
            con = obj.seleOneTestcaseContent(k)
            if len(con) == 0:
                continue
            else:
                print(con[0][0])
                dir1[p] = con[0][0]
    return dir1


def tihuan(dir):
    for p in file_full.keys():
        f1 = "/JVMfuzzing/wy/data/seed2/MyJVMTest_" + str(p) + ".java"
        if os.path.exists(f1) or file_full[p] == 1:
            continue
        with open(f1, "w") as f:
            if dir.keys().__contains__(p):
                f.write(dir[p])


# Filtering rules
# Rule 3 and 4 behave differently than other JVMs when defining array length as 2147483647.
def dealTSR1(mm):
    obj = Table_Result()
    obj2 = Table_Testcase()
    id_list = []
    list1 = obj.selectOOMFromTableSuspiciousResult(mm)
    listAll = obj.selectAllFromTableSuspiciousResult(mm)
    list1_1 = []
    for l in list1:
        list1_1.append(l[0])
    listAll_1 = []
    for l in listAll:
        listAll_1.append(l[0])

    for id in list1_1:
        print("*" * 10 + str(id) + "*" * 10)
        con = obj2.selectOneContextFromTestcaseContent(id)[0]
        # print(con)
        pattern = r'int \b[a-zA-Z0-9_]+(?= = 2147483647;)'
        match = re.search(pattern, con)
        if match:
            size_str = match.group()
            print("Found size:", size_str)
            pattern_new = r'new\s+[a-zA-Z0-9_]+\[' + size_str[4:] + r'\]'
            match_new = re.search(pattern_new, con)
            if match_new:
                print("Found:", match_new.group())
                id_list.append(id)
        else:
            print("Not found.")
    print("*" * 20 + "all" + "*" * 20)
    print(listAll_1)
    print(len(listAll_1))
    need_anal = []
    for i in listAll_1:
        if not id_list.__contains__(i):
            need_anal.append(i)
    # print(id_list)
    # print(len(id_list))
    return need_anal


# The errors "cannot find symbol" appeared during compilation for the suspicious results of 3 and 4.
def dealTSR2(mm, listAll=[]):
    obj = Table_Result()
    list1 = obj.selectCFSFromTableSuspiciousResult(mm)
    list1_1 = []
    for l in list1:
        list1_1.append(l[0])
    # print(list1)
    # print(len(list1))

    if len(listAll) == 0:
        temp = obj.selectAllFromTableSuspiciousResult(mm)
        temp_1 = []
        for l in temp:
            temp_1.append(l[0])
        listAll = temp_1
    need_anal = []
    for i in listAll:
        if not list1_1.__contains__(i):
            need_anal.append(i)
    return need_anal


# No class file was generated. When executing the java command, an error occurred: "Error: Could not find or load main class MyJVMTest_***".
def dealTSR3(mm, listAll=[]):
    obj = Table_Result()
    list1 = obj.selectCanFindClassFromTableSuspiciousResult(mm)
    list1_1 = []
    for l in list1:
        list1_1.append(l[0])
    # print(list1)
    # print(len(list1))

    if len(listAll) == 0:
        temp = obj.selectAllFromTableSuspiciousResult(mm)
        temp_1 = []
        for l in temp:
            temp_1.append(l[0])
        listAll = temp_1
    need_anal = []
    for i in listAll:
        if not list1_1.__contains__(i):
            need_anal.append(i)
    return need_anal


def dealTSR4(mm, listAll=[]):
    obj = Table_Result()
    list1 = obj.selectdivideZeroFromTableSuspiciousResult(mm)
    list1_1 = []
    for l in list1:
        list1_1.append(l[0])
    if len(listAll) == 0:
        temp = obj.selectAllFromTableSuspiciousResult(mm)
        temp_1 = []
        for l in temp:
            temp_1.append(l[0])
        listAll = temp_1
    need_anal = []
    for i in listAll:
        if not list1_1.__contains__(i):
            need_anal.append(i)
    return need_anal


def dealTSR5(mm, listAll=[]):
    obj = Table_Result()
    list1 = obj.selectOOM2FromTableSuspiciousResult(mm)
    list1_1 = []
    for l in list1:
        list1_1.append(l[0])
    if len(listAll) == 0:
        temp = obj.selectAllFromTableSuspiciousResult(mm)
        temp_1 = []
        for l in temp:
            temp_1.append(l[0])
        listAll = temp_1
    need_anal = []
    for i in listAll:
        if not list1_1.__contains__(i):
            need_anal.append(i)
    return need_anal


# mm=12    # mm=0 means all
# res1 = dealTSR1(mm)
# print("*"*20+str(1)+"*"*20)
# print(res1)
# print(len(res1))
#
# print("*"*20+str(2)+"*"*20)
# res2 = dealTSR2(mm,res1)
# print(res2)
# print(len(res2))
#
# print("*"*20+str(3)+"*"*20)
# res3 = dealTSR3(mm,res2)
# print(res3)
# print(len(res3))
#
# print("*"*20+str(4)+"*"*20)
# res4 = dealTSR4(mm,res3)
# print(res4)
# print(len(res4))
#
# print("*"*20+str(5)+"*"*20)
# res5 = dealTSR5(mm,res4)
# print(res5)
# print(len(res5))

# sumSeed()
# 计数
# C = Counter()
# sumLines = 0
# sumBranches = 0
# count_record = "/JVMfuzzing/wy/coverage/countHistory.txt"
# with open(count_record,'r')as f:
#     con = f.read()
# print(C.total_Coverage(con))


# C.count_from_string(con)
# obj = C.get_counts()
# for k,v in obj.items():
#     # print(k,len(v))
#     for k2,v2 in v.items():
#         if k2 == 'Branches':
#             sumBranches = sumBranches+len(v2)
#         elif k2 == 'Lines':
#             sumLines = sumLines+len(v2)
#
#
# # total Branches: 198397
# print(sumBranches)
# # total Lines: 361494
# print(sumLines)

# mm11 2850 testcases:
# 58558/198397 29.52%
# 159653/361494 44.16%



def count_files_in_directories(ss, main_directory):
    results = {}
    for s in ss:
        s_directories = find_directories(main_directory, s)
        for s_directory in s_directories:
            count = count_files_in_directory(s_directory)
            results[s] = results.get(s, 0) + count
    return results


def find_directories(directory, target):
    directories = []
    for dirpath, dirnames, filenames in os.walk(directory):
        if target in dirnames:
            s_directory = os.path.join(dirpath, target)
            directories.append(s_directory)
    return directories


def count_files_in_directory(directory):
    command = f"ls -lR {directory} | grep '^-' | wc -l"
    output = subprocess.check_output(command, shell=True)
    count = int(output.strip())
    return count


def count_files_with_bug(root):
    count = 0
    for filename in os.listdir(root):
        filepath = os.path.join(root, filename)
        if os.path.isfile(filepath):
            if has_bug(filepath):
                count += 1
        elif os.path.isdir(filepath):
            count += count_files_with_bug(filepath)
    return count


def has_bug(filepath):
    try:
        with open(filepath, 'r') as f:
            for line in f:
                if '@bug ' in line:
                    print("bug filepath: ",filepath)
                    return True
    except:
        pass
    return False


def count_java_files(root):
    count = 0
    for filename in os.listdir(root):
        filepath = os.path.join(root, filename)
        if os.path.isfile(filepath) and filename.endswith('.java'):
            count += 1
        elif os.path.isdir(filepath):
            count += count_java_files(filepath)
    return count



def parse_coverage_info(file_path):
    with open(file_path) as f:
        content = f.read()

    lines_index = content.find("lines......")
    functions_index = content.find("functions..")
    branches_index = content.find("branches...")

    lines_str = content[lines_index: functions_index]
    functions_str = content[functions_index: branches_index]
    branches_str = content[branches_index:]

    lines_data = lines_str.split(" ")
    functions_data = functions_str.split(" ")
    branches_data = branches_str.split(" ")
    print(lines_data)
    print(functions_data)
    print(branches_data)
    res ={}
    res["lines"]  = [round(float(lines_data[1][:-1])*0.01,3), int(lines_data[2].strip("(")), int(lines_data[4])]
    res["functions"]= [round(float(functions_data[1][:-1])*0.01,3), int(functions_data[2].strip("(")), int(functions_data[4])]
    res["branches"]= [round(float(branches_data[1][:-1])*0.01,3), int(branches_data[2].strip("(")), int(branches_data[4])]
    return res

#2.Parse the entire HTML directory (HtmlFile${NUM}) generated by command 2 and record it in the file at output_path.
def parse_html_file(filepath: str) -> Tuple[str, List[str]]:
    with open(filepath, 'r') as f:
        soup = BeautifulSoup(f, 'html.parser')
        pre_tag = soup.find_all('pre', class_='source')[0]
        a_tags = pre_tag.find_all('a')
        lines = []
        branches = []
        for a_tag in a_tags:
            if a_tag.find('span', class_='lineCov'):
                lines.append(int(a_tag.get('name')))
            if a_tag.find('span', class_='branchCov'):
                branch_tags = a_tag.find_all('span', class_='branchCov')
                for bg in branch_tags:
                    which_branch = str(bg.get('title')).split(' ')[1]
                    branches.append((int(a_tag.get('name')), int(which_branch)))

        return filepath, lines, branches

def parse_html_dir(root_dir: str) -> Tuple[List[str], List[str]]:
    html_files = []
    for root, dirs, files in os.walk(root_dir):
        for file in files:
            if file.endswith(('.cpp.gcov.html', '.hpp.gcov.html','.h.gcov.html')):
                html_files.append(os.path.join(root, file))
    files = {}
    with ThreadPoolExecutor() as executor:
        results = executor.map(parse_html_file, html_files)
        for filepath, file_lines, file_branches in results:
            print("*"*10+filepath+"*"*10)
            print(file_lines)
            print(file_branches)
            files[filepath] = {"lineCov":file_lines,"branchCov":file_branches}
    return files

def analyseHtmls(root_dir,output_path):
    res = parse_html_dir(root_dir)
    for filepath in res.keys():
        with open(os.path.join(root_dir, output_path), 'a') as f:
            f.write(f"FilePath:\n{filepath}\n")
            f.write(f"Lines:\n{res[filepath]['lineCov']}\n")
            f.write(f"Branches:\n{res[filepath]['branchCov']}\n")


if __name__=='__main__':
    print("123")

    # Record the test case numbers and store the count of numbers that do not include 'com' or 'com2' in a dictionary.
    # checkComm()
    # dir2 = readDB()
    # print(len(dir2))
    # tihuan(dir2)

    # start = '/root/jvm/openjdk11/jdk-11.0.17+8'
    # filepath = '/JVMfuzzing/wy/data/jarlist.txt'
    # target = '/JVMfuzzing/wy/data/list.txt'
    # res = dealcp(start,filepath,target)
    # print(res)

    # # Write test cases to a database.
    # dir = '/JVMfuzzing/wy/data/test12/'
    # writeToDB(dir,12)

    # dir = "/root/jvm/openjdk11/jdk-11.0.17+8/test/jdk/sun"
    # dir = "/root/jvm/openjdk11/jdk-11.0.17+8/src/java.base/share/classes/jdk/internal"
    # addExports(dir)

    # with open("/JVMfuzzing/wy/Comfort_all/data/addExports.txt","r") as f:
    #     res = f.readlines()
    # cmd = []
    # for s in res:
    #     if s != '':
    #         cmd.append(s[:-1])
    # print(cmd)

    




    # ss = ['aot','asm','c1','ci','compiler','gc','interpreter','jfr','libadt',
    #       'logging','memory','oops','opto','prims','runtime','services','utilities']

    # ss = ['jtreg', 'gtest']
    # root = "/root/jvm/openjdk11/jdk-11.0.17+8/test"

    # bug：14144
    # jtreg：13866,186
    # total:31328
    # root = '/root/jvm/openj9-jdk11/openj9-jdk11_0718/openj9-openjdk-jdk11/test'
    # bug：14102
    # jtreg：13851,186
    # total:31266
    # root = "/JVMfuzzing/wy/graaltest"
    # bug：14146
    # jtreg：13886,186
    # total:31349

    # 1. Get the number of files in the JDK source code directory and return it as a dictionary. The dictionary should include the number of files in the folder, the number of bug files, and the number of Java files.
    # res1 = count_files_in_directories(ss, root)
    # print(res1)
    # res2 = count_files_with_bug(root)
    # print(res2)
    # res3 = count_java_files(root)
    # print(res3)

    

    # res = parse_coverage_info("/JVMfuzzing/wy/all3.txt")
    # print(res)


    # root_dir = '/JVMfuzzing/wy/HtmlFile3'
    # output_path = '/JVMfuzzing/wy/analyse3.txt'
    # analyseHtmls(root_dir,output_path)

    '''
    #3.2 After parsing the HTML directories (HtmlFile${NUM}) twice, the files analyse1.txt and analyse2.txt were generated. Compare if new coverage has been generated.
    #get new coverage
    #params:test1f and test2f are the results obtained from reading the coverage of two tests, which were analyzed from the Html directory. They are the second parameter of the analyseHtmls function.
    def get_new_coverage(test1f,test2f):
        # Read the files test1 and test2.
        with open(test1f, 'r') as f1:
            test1 = f1.readlines()
        with open(test2f, 'r') as f2:
            test2 = f2.readlines()
        prefix = "/JVMfuzzing/wy/HtmlFile3"             #Attention to directory prefixes.
        test1_files = get_file_info(test1,prefix)
        test2_files = get_file_info(test2,prefix)

        # Comparing file information to check if test2 discovered any new files/lines/branches that test1 did not discover.
        resultF = []
        resultL = []
        resultB = []
        new_coverage = False
        for file_path, info2 in test2_files.items():
            if file_path not in test1_files:
                if len(info2['Lines'])==0 and len(info2['Branches'])==0:
                    continue
                resultF = [file_path]
                new_coverage = True
                break
            info1 = test1_files[file_path]
            if len(info2['Lines'])>0 and info1['Lines']!=info2['Lines']:
                set1 = set(info1['Lines'])
                resultL = [x for x in info2['Lines'] if x not in set1]
                if len(resultL) > 0:
                    new_coverage = True
                    break
            if len(info2['Branches'])>0 and info2['Branches'] !=info1['Branches']:
                set1 = set(info1['Branches'])
                resultB = [x for x in info2['Branches'] if x not in set1]
                if len(resultB) > 0:
                    new_coverage = True

        if new_coverage:
            print("New Coverage!")
        else:
            print("Coverage Unchanged")
        return resultF,resultL,resultB
    # Extracting file information.
    def get_file_info(lines,prefix):
        file_info = {}
        for i in range(0,len(lines),2):
            line = lines[i].strip()
            if line.startswith('FilePath:'):
                file_path = str(lines[i+1].strip())
                file_path = file_path.replace(prefix, "")
                file_info[file_path] = {'Lines': [], 'Branches': []}
            elif line.startswith('Lines:'):
                lines_str = json.loads(lines[i+1].strip())
                file_info[file_path]['Lines'] = lines_str
            elif line.startswith('Branches:'):
                branches_str = lines[i+1].strip()
                if branches_str != '[]':
                    branches = branches_str[1:-1].split('),')
                    for b in branches:
                        branch_info = b.strip()[1:].split(',')
                        branch_line = int(branch_info[0])
                        if branch_info[1].endswith(')'):
                            branch_info[1] = branch_info[1][:-1]
                        branch_num = int(branch_info[1])
                        file_info[file_path]['Branches'].append((branch_line, branch_num))
        return file_info

    # test1f="/JVMfuzzing/wy/analyse1.txt"
    # test2f="/JVMfuzzing/wy/analyse2.txt"
    # newFile,newLines,newBranches = get_new_coverage(test1f,test2f)
    # print(newFile)
    # print(newLines)
    # print(newBranches)
    '''
    
'''
    #3.1.1 After parsing an HTML directory (HtmlFile${NUM}) once, an analyse1.txt file is obtained, which records the frequency of each triggered line and each branch calculated.
    def get_frequency(analysef,prefix):
        with open(analysef, 'r') as f1:
            analyse1 = f1.readlines()
        analyse1_files = get_file_info(analyse1,prefix)
        c = Counter()
        #Approach 1: Counting based on the return result of get_file_info.
        c.count(analyse1_files)
        str1 = c.get_counts()
        print(str1)
        c2 = Counter()
        #Approach 2: Input historical count information (converting the return value of get_counts to str) and continue counting on this basis.
        c2.count_from_string(str(str1))
        print(c2.get_counts())

    #3.1.2 After calculating frequencies, entropy values need to be calculated based on the Counter results.
    def get_energy():
        energy = 0
        return energy

    #3.1.3 Recursively traverse the directory test9_1 (including subdirectories), read the variation operator database and ID numbers related to the test cases (read_mutators_fromDir)
    def read_mutator(filepath):
        filename = filepath.split("/")[-1].split(".")[0]
        data = {"Variables":[],"Statement":[]}
        with open(filepath, "r") as f:
            for line in f:
                if "Variables" in line or "Statement" in line:
                    parts = line.strip()[1:-1].split(", ")
                    for i in range(0, len(parts),2):
                        if parts[i] == "Variables":
                            data["Variables"].append(int(parts[i+1]))
                        elif parts[i] == "Statement":
                            data["Statement"].append(int(parts[i+1]))
        return filename, data
    def get_files(directory):
        txt_files = []
        for root, dirs, files in os.walk(directory):
            for file in files:
                if file.endswith(".txt"):
                    txt_files.append(os.path.join(root, file))
        return txt_files
    def read_mutators_fromDir(dir,mm):
        txt_files = get_files(dir)
        files_data = {str(mm):{}}
        for f in txt_files:
            filename,data = read_mutator(f)
            files_data[str(mm)][filename] = data
        return files_data

    #3.1.4 Writing entropy back to the variation operator database energy
    def write_energy(dir,mm):
        files_data = read_mutators_fromDir(dir,mm)
        for k,v in files_data.items():
            for name,DB_ids in v.items():
                list1 = DB_ids['Variables']
                list2 = DB_ids['Statement']
                print('Variables',list1)
                print('Statement',list2)
                return


    test1f="/JVMfuzzing/wy/analyse1.txt"
    prefix = "/JVMfuzzing/wy/HtmlFile3"
    get_frequency(test1f,prefix)

    mutator_file = "/JVMfuzzing/wy/MyJVMTest_1.txt"
    name,data = read_mutator(mutator_file)
    print(name,data)
    dir = "/JVMfuzzing/wy/test1/"
    mm = 1
    data = read_mutators_fromDir(dir,mm)
    print(data)
    write_energy(dir,mm)
'''

'''
    def getSeed(put_seed_dir):
        obj = Table_Testcase()
        con_list = obj.selectAllJavacR0FromTableTestcase()
        for s in con_list:
            con = s[0]
            pattern = r"(public class )(MyJVMTest_[\d]*?)(?=(\s{)|{)"
            # print(re.search(pattern, Testcase_context))
            name = re.search(pattern, con).group(2)
            file = put_seed_dir+name+".java"
            if os.path.exists(file):
                num = get_num(file)
                if num == -1:
                    continue
                while(os.path.exists(file)):
                    file = put_seed_dir+"MyJVMTest_"+str(num+1)+".java"
                    num+=1
                con = changeName(con,num)
                with open(file,"w")as f:
                    f.write(con)
            else:
                with open(file,"w")as f:
                    f.write(con)

    def changeName(s, num):
        pattern = r"MyJVMTest_\d+"
        matches = re.findall(pattern, s)
        for match in matches:
            s = s.replace(match, f"MyJVMTest_{num}")
        return s

    def get_num(filename):
        pattern = r".*/MyJVMTest_([0-9]+)\.java"
        match = re.match(pattern, filename)
        number = -1
        if match:
            number = int(match.group(1))
        return number

    put_seed_dir = '/JVMfuzzing/wy/data/seed_new/'
    getSeed(put_seed_dir)
'''