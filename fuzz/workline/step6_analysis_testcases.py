import subprocess
import sys
import time
from pathlib import Path
from typing import List
import os
from workline.harness_tools.harness_class_javac import Harness as H_javac

from workline.harness_tools.harness_class import HarnessResult, DifferentialTestResult

BASE_DIR = str(Path(__file__).resolve().parent.parent)
sys.path.append(BASE_DIR)

from workline.table_to_class.Table_Testcase_Class import Testcase_Object

from src.studyMysql.Table_Operation import Table_Suspicious_Result



def findTypeId(type_name):
    table_Suspicious_Result = Table_Suspicious_Result()
    testcase_list = table_Suspicious_Result.selectErrorTypeFromTableFunction(type_name)
    testcase_id_set = set()
    for item in testcase_list:
        testcase_id_set.add(item[2])
    print(f"There are {len(testcase_id_set)} {type_name} test cases.")
    print(testcase_id_set)
    # print(crash_testcase_id_set)


def harness_testcase(testcase) -> (HarnessResult, HarnessResult, List[DifferentialTestResult]):
    testcase_object = Testcase_Object(testcase)
    print('*' * 25 + f'Differential Test Case {testcase_object.Id}' + '*' * 25)
    start_time = time.time()
    harness = H_javac()
    print(testcase)
    harness.get_class_name(testcase[1])
    name = harness.name+".class"
    javac_result = testcase_object.engine_compile_testcase()
    time.sleep(2)
    # Obtain differential results, outputs from various engines.
    harness_result = testcase_object.engine_run_testcase()

    # Vote.
    different_result_list = harness_result.differential_test()

    print(f"Total time elapsed: {int(time.time() - start_time)} seconds.")

    return javac_result,harness_result, different_result_list


if __name__ == '__main__':
    findTypeId("'crash'")
    findTypeId("'Pass value *** run error'")
    findTypeId("'Most JS engines pass'")
    findTypeId("'Majority JS engines throw runtime error/exception'")
    findTypeId("'Most JS engines crash'")

    
    # interesting_testcase = table_Testcase.selectOneFromTableTestcase(24532)
    # harness_testcase(interesting_testcase)
