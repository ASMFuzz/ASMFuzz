# export LC_ALL=C
import os.path
import sys
from pathlib import Path

BASE_DIR = str(Path(__file__).resolve().parent.parent)
sys.path.append(BASE_DIR)

from src.studyMysql.Table_Operation import Table_Testcase
from workline.table_to_class.Table_Testcase_Class import Testcase_Object

table_Testcases = Table_Testcase()

# list_unfuzzing = table_Testcases.selectMutationMethodFromTableTestcase(3)
want_tescase_id = 565268
# [1:openjdk17,  2:openjdk11,  3:openj9-17,  4:openj9-11,    5:zulu-17,  6:zulu-11,  7:graal-17, 8:graal-11]


testbed_id = 3
testcase = table_Testcases.selectOneFromTableTestcase(want_tescase_id)
content = ""
index = 824
# index = 41964
file_path = os.path.join(BASE_DIR, "data/JVMtestcases/singleRun/")

name = "MyJVMTest_" + str(index) + ".java"
with open(file_path + name, "r") as f:
    content = f.read()
print(content)
# print("run here")
new_3 = "/root/jvm/openj9-jdk17-new/openj9-openjdk-jdk17/build/linux-x86_64-server-release/images/jdk/bin/java"
new_4 = "/root/jvm/openj9-jdk11-new/openj9-openjdk-jdk11/build/linux-x86_64-normal-server-release/images/jdk/bin/java"

want_testbed_location = new_3  # new
testcase_object = Testcase_Object(testcase)


def javac_compile_single(testbed_id, isModified):
    if isModified:
        testcase_object.Testcase_context = content
    print('*' * 25 + f'compile{testcase_object.Id}' + '*' * 25)
    Compiled_result = testcase_object.single_engine_compile(testbed_id, want_testbed_location)
    print(Compiled_result[0])


def single_harness(testbed_id):
    print('*' * 25 + f'run{testcase_object.Id}' + '*' * 25)
    run_result = testcase_object.single_engine_run(testbed_id, want_testbed_location)
    print(run_result[0])


isModified = True
print("*" * 25 + " Results " + "*" * 25)
javac_compile_single(testbed_id, isModified)
single_harness(testbed_id)
print("*" * 25 + " Testcase " + "*" * 25)
print(testcase_object.Testcase_context)
