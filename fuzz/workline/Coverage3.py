import os
import subprocess
import sys

curPath = os.path.abspath(os.path.dirname(__file__))
rootPath = os.path.split(curPath)[0]
sys.path.append(rootPath)
from src.studyMysql.Table_Operation import Table_Testcase
from workline.Counter import Counter
from workline.Energy import Energy
from workline.table_to_class.Table_Testcase_Class import Testcase_Object
from workline.harness_tools.harness_class_javac import Harness as H_javac
import pathlib

class Coverage3:
    def __init__(self):
        self.listTestcase = []
        self.want_testbed_location = "/root/jvm/openjdk11/jdk11.14.3/jdk-11.0.14-ga/build/linux-x86_64-normal-server-release/images/jdk/bin/java"
    def getListTestcase(self, mm):
        table_Testcases = Table_Testcase()
        self.listTestcase = table_Testcases.selectMutationMethodFromTableTestcase(mm)
        if len(self.listTestcase) == 0:
            print("no testcase exist.")
    def javac_Testcases(self,group,mm):
        for testcase in group:
            self.javac_compile_single(testcase,mm)
        print("all testcase compiled finshed.")

    def run_Testcases(self,group,mm):
        for testcase in group:
            self.single_harness(testcase,mm)
        print("all testcase executed finshed.")

    def javac_compile_single(self,testcase,mm):
        testcase_object = Testcase_Object(testcase)
        counter = self.check(testcase_object.Testcase_context,mm)
        if counter == 1:
            return
        testcase_object.single_engine_compile_coverage(self.want_testbed_location,mm)

    def single_harness(self,testcase,mm):
        testcase_object = Testcase_Object(testcase)
        counter = self.check(testcase_object.Testcase_context,mm)
        if counter == 1:
            testcase_object.single_engine_run_coverage(self.want_testbed_location,mm)

    def check(self, testcase,mm) -> int:
        counter = 0
        code_files = "/tmp/comfort_jvm_cov/"+str(mm)+"/"
        harness = H_javac()
        harness.get_class_name(testcase)
        class_path = pathlib.Path(
            code_files + self.want_testbed_location.split("/")[3] + "/out/" + harness.name + ".class")
        # print(class_path)
        if class_path.is_file() and os.stat(str(class_path)).st_size > 0:
            print("class file exists.classfile path is: ", class_path)
            counter = 1
        else:
            print("class file doesn't exists.  ")
        return counter
obj1 = Coverage3()
obj2 = Energy()
c = Counter()

mm=11
obj1.getListTestcase(mm)
# obj1.javac_Testcases(obj1.listTestcase,mm)
# obj1.run_Testcases(obj1.listTestcase,mm)

script_directory = "/JVMfuzzing/wy"
script_name = "time_coverage3.sh"
arg1_logfile = "/JVMfuzzing/wy/coverage2/mm" + str(mm) + "/log.txt"
arg2_mm = str(mm)
arg3_index = "0"
subprocess.run(['bash', script_name, arg1_logfile, arg2_mm, arg3_index], cwd=script_directory)

