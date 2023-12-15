# -*- coding: utf-8 -*-
import time, sys
# export LC_ALL=C
from multiprocessing.dummy import Pool as ThreadPool
from pathlib import Path

BASE_DIR = str(Path(__file__).resolve().parent.parent)
sys.path.append(BASE_DIR)
from src.studyMysql.Table_Operation import Table_Testcase, Table_Result
from workline.table_to_class.Table_Testcase_Class import Testcase_Object

table_Testcases = Table_Testcase()


# list_unfuzzing = []
# table_Result = Table_Result()
# list_not_have_in_Results_ids = table_Result.selectFromNotHaveInResult()
# list_not_complete_javac_ids = table_Result.selectFromNotCompleteInResult()
# for id in list_not_have_in_Results_ids:
#     if id not in list_not_complete_javac_ids:
#         list_unfuzzing.append(table_Testcases.selectIdFromTableTestcase(id[0])[0])
# print(len(list_unfuzzing))


# result_returncode0 = set(table_Testcases.selectTestcaseIdFromTableJavacResult(0))
# result_returncode1 = set(table_Testcases.selectTestcaseIdFromTableJavacResult(1))


def muti_javac_compile(testcase, isInsert=True):
    testcase_object = Testcase_Object(testcase)
    print('*' * 25 + f'compile{testcase_object.Id}' + '*' * 25)
    Compiled_result = testcase_object.engine_compile_testcase()
    if isInsert:
        # print("Compiled_result.outputs: ",Compiled_result.outputs)
        if Compiled_result != None:
            # print(testcase_object.Id, " Start insert results...", len(Compiled_result.outputs))
            Compiled_result.save_to_table_result()
            # print("different_result_list")
            # 投票
            different_result_list = Compiled_result.differential_test()
            # print(different_result_list)
            if not len(different_result_list):
                print("nothing happened.")
            else:
                print("{}error has been occured by java compiler.".format(len(different_result_list)))
                for interesting_test_result in different_result_list:
                    # print(interesting_test_result)
                    interesting_test_result.save_to_table_suspicious_Result()

            print(f'Spending time:{int(time.time() - start_time)}s')
        else:
            print('*' * 25 + f'{testcase_object.Id} has no content.' + '*' * 25)


def check(testcase):
    testcase_object = Testcase_Object(testcase)
    counter = testcase_object.check_classfile()
    print(f'{testcase_object.Id} classfiles has been made: ' + str(counter))
    '''
        with open("./list_counter9.txt", "r", encoding="utf-8") as f:  # 8541
            list1 = f.read().split("\n")
        with open("./list_returncode0.txt", "r", encoding="utf-8") as f:  # 6484
            list2 = f.read().split("\n")
        if str(testcase_object.Id) in list1 and str(testcase_object.Id) not in list2:
            with open("./list_diff_9&r0.txt", "a+", encoding="utf-8") as f:
                f.write(str(testcase_object.Id))
                f.write("\n")
        if counter == 9:
            with open("./list_counter9.txt", "a+", encoding="utf-8") as f:
                f.write(str(testcase_object.Id))
                f.write("\n")
        elif counter == 0:
            with open("./list_counter0.txt", "a+", encoding="utf-8") as f:
                f.write(str(testcase_object.Id))
                f.write("\n")
        list_returncode0 = []
        list_returncode1 = []
        for id in result_returncode0:
            list_returncode0.append(id[0])
        for id in result_returncode1:
            list_returncode1.append(id[0])
        print(len(list_returncode1), len(list_returncode0))
        if testcase_object.Id in list_returncode0:
            with open("./list_returncode0.txt", "a+", encoding="utf-8") as f:
                f.write(str(testcase_object.Id))
                f.write("\n")
        elif testcase_object.Id in list_returncode1:
            with open("./list_returncode1.txt", "a+", encoding="utf-8") as f:
                f.write(str(testcase_object.Id))
                f.write("\n")
    '''
    return counter


def muti_harness(testcase, isInsert=True):
    testcase_object = Testcase_Object(testcase)
    counter = check(testcase)
    if counter == 0:
        print(f"{testcase_object.Id} no classfile found.")
        return
    print('*' * 25 + f'running{testcase_object.Id}' + '*' * 25)
    start_time = time.time()
    harness_result = testcase_object.engine_run_testcase(time="60")
    if isInsert:
        if harness_result != None:
            try:
                harness_result.save_to_table_result()
            except:
                pass
            different_result_list = harness_result.differential_test()
            if not len(different_result_list):
                print("nothing happened.")
            else:
                print("{}error has been occured by JVM.".format(len(different_result_list)))
                testcase_object.add_interesting_times(1)
                for interesting_test_result in different_result_list:
                    # print(interesting_test_result)
                    interesting_test_result.save_to_table_suspicious_Result()
            # print(f"------------------------------------------------------\n")
        print(f'Spending time:{int(time.time() - start_time)}s')
        testcase_object.updateFuzzingTimesInterestintTimes()


def run_javac_demo(list_unfuzzing):
    for testcase in list_unfuzzing:
        try:
            muti_javac_compile(testcase)
        except Exception as e:
            print("muti_javac_compile catch Exception:")
            print(e)
        file_counter = check(testcase)
        if file_counter == 0:
            print("update insteresting times to -1")
            faile_compiler(testcase=testcase)
        elif file_counter != 9:
            print("incorrect file count: ", file_counter)
        elif file_counter == 9:
            print("incorrect file count: ", file_counter)
            muti_harness(testcase)

def faile_compiler(testcase):
    testcase_object = Testcase_Object(testcase)
    testcase_object.failcompiler_interesting()
    testcase_object.updateFuzzingTimesInterestintTimes()

if __name__ == '__main__':
    # list_unfuzzing = table_Testcases.selectAllFromTableTestcase()
    # list_unfuzzing = table_Testcases.selectFuzzingTimeFromTableTestcase(1)
    # list_unfuzzing = table_Testcases.selectMutationMethodFromTableTestcase(12)
    # list_unfuzzing =  table_Testcases.selectMutationMethodFromTableTestcase3(11)
    # list_unfuzzing = table_Testcases.selectMutationMethodFromTableTestcaseNotJavac(12)
    # list_unfuzzing = table_Testcases.selectMutationMethodFromTableTestcase(12)
    list_unfuzzing = table_Testcases.selectOneFromTableTestcase(100)
    print("There are %d undifferentiated test cases in total." % len(list_unfuzzing))
    # print(len(list_unfuzzing), type(list_unfuzzing))
    start_time = time.time()
    run_javac_demo(list_unfuzzing)
    end_time = time.time()
    print(f'take {int(end_time - start_time)}s second. ')
