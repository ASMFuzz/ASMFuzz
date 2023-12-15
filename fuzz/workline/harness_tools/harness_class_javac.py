import collections
import json
import math
import logging
import pathlib
import subprocess
import gc
import re
from threading import Thread
from typing import List
import os
from src.studyMysql.Table_Operation import Table_Testbed, Table_Result, Table_Suspicious_Result
from src.utils import labdate

from pathlib import Path

BASE_DIR = str(Path(__file__).resolve().parent.parent.parent)
listTxt = os.path.join(BASE_DIR, "data/harness/list.txt")
code_files = os.path.join(BASE_DIR, 'shannon_v0/')
code_files_cov = os.path.join(BASE_DIR, 'shannon_v0/')
addExportsPath = os.path.join(BASE_DIR, 'data/harness/addopens.txt')

Majority = collections.namedtuple('Majority', [
    'majority_outcome', 'outcome_majority_size',
    'majority_stdout', 'stdout_majority_size'
])

javac_classpath = ["-classpath", "/root/jvm/openjdk17/jdk-17.0.5+8/build/linux-x86_64-server-release/images/jdk/lib:"
                                 "/root/jvm/openjdk11/jdk-11.0.14-ga/build/linux-x86_64-normal-server-release/images/jdk/lib:"
                                 "/root/jvm/openj9-jdk11/openj9-openjdk-jdk11/build/linux-x86_64-normal-server-release/images/images/lib:"
                                 "/root/jvm/openj9-jdk17/openj9-openjdk-jdk17/build/linux-x86_64-server-release/images/jdk/lib:"
                                 "/root/jvm/zulu-jdk17/zulu17.38.21-ca-jdk17.0.5-linux_x64/lib:"
                                 "/root/jvm/zulu-jdk11/zulu11.60.19-ca-jdk11.0.17-linux_x64/lib:"
                                 "/root/jvm/graal-jdk17/graalvm-ce-java17-22.3.0/lib:"
                                 "/root/jvm/graal-jdk11/graalvm-ce-java11-22.3.0/lib:"
                                 "/JVMfuzzing/htm/java_code/HotspotOut:"
                                 "/JVMfuzzing/htm/java_code/HtmOut:"
                   ]
with open(listTxt, "r") as f:
    res = f.read()
addExports = []
with open(addExportsPath, 'r') as f:
    addExports = f.readlines()
javac_classpath[1] = javac_classpath[1] + res

testbed_info = ['openjdk17', 'openjdk11', 'openj9-jdk17', 'openj9-jdk11', 'zulu-jdk17', 'zulu-jdk11', 'graal-jdk17',
                'graal-jdk11', 'openjdk8', 'openj9-jdk8', 'zulu-jdk8', 'kona-jdk8', 'kona-jdk11', 'graal-jdk11',
                'jdk11u-dev']


def check_and_create_dir():
    # print("checking java dir and out dir...")
    for jvm_name in testbed_info:
        dir_path = code_files + jvm_name
        if not os.path.exists(dir_path):
            os.makedirs(dir_path)
        if not os.path.exists(dir_path + "/out/"):
            os.makedirs(dir_path + "/out/")


check_and_create_dir()


class DifferentialTestResult:
    def __init__(self, function_id: int, testcase_id: int, error_type: str, testbed_id: int, testbed_location: str):
        self.function_id = function_id
        self.testcase_id = testcase_id
        self.error_type = error_type
        self.testbed_id = testbed_id
        self.testbed_location = testbed_location
        self.classify_result = None
        self.classify_id = None
        self.remark = None

    def serialize(self):
        return {"Differential Test Result": {"testcase_id": self.testcase_id,
                                             "error_type": self.error_type,
                                             "testbed_id": self.testbed_id,
                                             "function_id": self.function_id,
                                             "inconsistent_testbed": self.testbed_location,
                                             "classify_result": self.classify_result,
                                             "classify_id": self.classify_id
                                             }}

    def __str__(self):
        return json.dumps(self.serialize(), indent=4)

    def save_to_table_suspicious_Result(self):
        """
        Save the result to the database
        :return:
        """
        table_suspicious_Result = Table_Suspicious_Result()
        table_suspicious_Result.insertDataToTablejavacSuspiciousResult(self.error_type, self.testcase_id,
                                                                       self.function_id,
                                                                       self.testbed_id,
                                                                       self.remark)


class HarnessResult:
    """
    This is the result type of the differential test, as opposed to ResultClass,
    which is the type that holds the results of the execution at runtime.
    """

    def __init__(self, function_id: int, testcase_id: int, testcase_context: str):
        self.function_id = function_id
        self.testcase_id = testcase_id
        self.testcase_context = testcase_context
        self.outputs: list[Output] = []

    def __str__(self):
        return json.dumps({"Harness_Result": {"testcase_id": self.testcase_id,
                                              "testcase_context": self.testcase_context,
                                              "outputs": [e.serialize() for e in self.outputs]
                                              }
                           }, indent=4)

    def get_majority_output(self) -> Majority:
        """Majority vote on testcase outcomes and outputs."""
        # print(result)

        majority_outcome, outcome_majority_size = collections.Counter([
            output.output_class for output in self.outputs
        ]).most_common(1)[0]
        majority_stdout, stdout_majority_size = collections.Counter([
            output.stdout for output in self.outputs
        ]).most_common(1)[0]
        return Majority(majority_outcome, outcome_majority_size,
                        majority_stdout, stdout_majority_size)

    def differential_test(self) -> List[DifferentialTestResult]:
        if self.outputs is None:
            return []
        ratio = 2 / 3
        majority = self.get_majority_output()
        testbed_num = len(self.outputs)
        # print(testbed_num)

        bugs_info = []
        for output in self.outputs:
            if output.output_class == "crash":
                bugs_info.append(
                    DifferentialTestResult(self.function_id, self.testcase_id, "crash", output.testbed_id,
                                           output.testbed_location))
                pass
            elif majority.majority_outcome != output.output_class and majority.outcome_majority_size >= math.ceil(
                    ratio * testbed_num):
                if majority.majority_outcome == "pass":
                    bugs_info.append(
                        DifferentialTestResult(self.function_id, self.testcase_id, "Most Java engines pass",
                                               output.testbed_id,
                                               output.testbed_location))
                elif majority.majority_outcome == "timeout":
                    # Usually, this is not a bug
                    pass
                elif majority.majority_outcome == "crash":
                    bugs_info.append(
                        DifferentialTestResult(self.function_id, self.testcase_id, "Most Java engines crash",
                                               output.testbed_id,
                                               output.testbed_location))
                elif majority.majority_outcome == "script_error":
                    bugs_info.append(
                        DifferentialTestResult(self.function_id, self.testcase_id,
                                               "Majority Java engines throw runtime error/exception",
                                               output.testbed_id,
                                               output.testbed_location))
            elif output.output_class == "pass" and majority.majority_outcome == output.output_class and \
                    output.stdout != majority.majority_stdout and \
                    majority.stdout_majority_size >= math.ceil(ratio * majority.outcome_majority_size):
                if majority.outcome_majority_size >= math.ceil(ratio * testbed_num):
                    bugs_info.append(
                        DifferentialTestResult(self.function_id, self.testcase_id, "Pass value *** run error",
                                               output.testbed_id,
                                               output.testbed_location))
        return bugs_info

    def save_to_table_result(self):
        """
        Save the result to the database.
        :return:
        """
        table_result = Table_Result()
        for output in self.outputs:
            # print(output)
            if len(output.stderr) > 0:
                print(output.stderr)
            table_result.insertDataToTablejavacResult(self.testcase_id, output.testbed_id, output.returncode,
                                                      output.stdout,
                                                      output.stderr, output.duration_ms, 0, 0,
                                                      None)


class Output:
    def __init__(self,
                 testbed_id: int,
                 testbed_location: str,
                 returncode: int,
                 stdout: str,
                 stderr: str,
                 duration_ms: int,
                 event_start_epoch_ms: int):
        self.testbed_id = testbed_id
        self.testbed_location = testbed_location
        self.returncode = returncode
        self.stdout = stdout
        self.stderr = stderr
        self.duration_ms = duration_ms
        self.event_start_epoch_ms = event_start_epoch_ms
        self.output_class = self.get_output_class()

    def get_output_class(self) -> str:
        """
        The order in which branches are judged cannot be reversed，
        because Whether the test case has a syntax error or not, chakraCore's returnCode is equal to 0
        """
        if self.returncode == -9 and self.duration_ms > 30 * 1000:
            return "timeout"
        elif self.returncode < 0:
            return "crash"
        elif self.returncode > 0 or not self.stderr == "":
            return "script_error"
        else:
            return "pass"

    def serialize(self):
        return {"testbed_id": self.testbed_id,
                "testbed_location": self.testbed_location,
                "returncode": self.returncode,
                "stdout": self.stdout,
                "stderr": self.stderr,
                "duration_ms": self.duration_ms,
                "event_start_epoch_ms": self.event_start_epoch_ms
                }

    def __str__(self):
        return json.dumps({"testbed_id": self.testbed_id,
                           "testbed_location": self.testbed_location,
                           "returncode": self.returncode,
                           "stdout": self.stdout,
                           "stderr": self.stderr,
                           "duration_ms": self.duration_ms,
                           "event_start_epoch_ms": self.event_start_epoch_ms},
                          indent=4)


class ThreadLock(Thread):
    def __init__(self, testbed_location, testcase_path, testbed_id, mm=0):
        super().__init__()
        self.testbed_id = testbed_id
        self.output = None
        self.testbed_location = testbed_location
        self.testcase_path = testcase_path
        self.returnInfo = None
        self.isCov = False
        self.mm = mm

    def run(self):
        try:
            # Add the step of compiling with javac.
            self.output = self.get_classFile(self.testbed_location, self.testcase_path, self.testbed_id)
        except BaseException as e:
            self.returnInfo = 1

    def get_classFile(self, testbed_location: str, testcase_path: pathlib.Path, testbed_id, time: str = "30"):
        if self.isCov == True:
            # code_files2 = "/tmp/comfort_jvm_cov/" + str(self.mm) + "/"
            code_files2 = os.path.join(code_files_cov, str(self.mm))

        else:
            code_files2 = code_files
        cmd = ["timeout", "-s9", time]
        testbed_location += "c"
        for ob in testbed_location.split():
            cmd.append(ob)
        cmd.append("-XDignore.symbol.file")
        cmd.append(javac_classpath[0])
        cmd.append(javac_classpath[1])
        jvm_name = testbed_location.split("/")[3]
        cmd.append(str(testcase_path))
        cmd.append("-d")
        cmd.append(os.path.join(code_files2, jvm_name) + "/out")
        # print(code_files2 + jvm_name + "/out")
        # print(os.path.join(code_files2, jvm_name))
        start_time = labdate.GetUtcMillisecondsNow()
        try:
            # print("javac start cmd:", cmd)
            # pro = subprocess.Popen(cmd, shell=False,universal_newlines=True,stdout=subprocess.PIPE,stderr=subprocess.STDOUT)
            pro = subprocess.Popen(cmd, shell=False, universal_newlines=True, stdout=subprocess.PIPE,
                                   stderr=subprocess.PIPE)
            stdout, stderr = pro.communicate()
            # print(stderr,stdout)
            print("stderr+stdout: ", stderr, stdout)
            end_time = labdate.GetUtcMillisecondsNow()
            duration_ms = int(round(
                (end_time - start_time).total_seconds() * 1000))
            event_start_epoch_ms = labdate.MillisecondsTimestamp(start_time)
            output = Output(testbed_id=testbed_id, testbed_location=testbed_location, returncode=pro.returncode,
                            stdout=stdout,
                            stderr=stderr,
                            duration_ms=duration_ms, event_start_epoch_ms=event_start_epoch_ms)

            print("javac finished.")
            # print(output.serialize())
            return output
        except Exception as e:
            print("javac failed: ", e)


class Harness:

    @staticmethod
    def get_engines():
        table_testbed = Table_Testbed()
        testbed_list = table_testbed.selectAllIdAndLocateFromTableTestbed()
        return testbed_list

    def __init__(self):
        """
        initialize harness
        :param engines: engines to be test
        """
        self.engines = self.get_engines()
        self.name = ""

    def get_class_name(self, Testcase_context):
        # pattern = r"(public class )([a-zA-Z_\d]*?)(?=(\s{)|{)"
        pattern = r"(public class )(MyJVMTest_[\d]*?)(?=(\s{)|{)"
        # print(re.search(pattern, Testcase_context))
        # print(Testcase_context)
        name = re.search(pattern, Testcase_context).group(2)
        # public class MyJVMTest_5036
        print("get_class_name: ", name)
        self.name = name

    def run_testcase(self, function_id: int, testcase_id: int, testcase_context: str) -> HarnessResult:
        """
        Execute test cases with multiple engines and return test results after execution of all engines.
        :param function_id: executed function Id
        :param testcase_id:  executed Testcases Id
        :param testcase_context: Testcases to be executed
        :return: test results
        """
        result = HarnessResult(function_id=function_id, testcase_id=testcase_id, testcase_context=testcase_context)
        result.outputs = self.multi_thread(self.name, testcase_context)
        # result.outputs = self.single_thread(name,testcase_context)
        return result

    def check_classfile(self, name) -> int:
        counter = 0
        for engine in self.engines:
            testbed_location = engine[1]
            class_path = pathlib.Path(code_files + testbed_location.split("/")[3] + "/out/" + name + ".class")
            print("check_classfile: ", class_path)
            if class_path.is_file() and os.stat(str(class_path)).st_size > 0:
                print("class file exists.classfile path is: ", class_path)
                counter += 1
            else:
                print("class file doesn't exists.  ")
                counter += 0
        return counter

    def multi_thread(self, class_name: str, testcase_context: str) -> List[Output]:
        """
        Multithreading test execution test cases
        :param testcase_path: path of the test case
        :return: execution results of all engines
        """
        # print("runhere")
        # print(self.engines)
        outputs = []
        threads_pool = []
        for engine in self.engines:
            testbed_id = engine[0]
            testbed_location = engine[1]
            # print(testbed_location)
            jvm_name = testbed_location.split("/")[3]
            new_file_loc = code_files + jvm_name + "/" + class_name + ".java"
            # print("new_file_loc: ", new_file_loc)
            with open(new_file_loc, "w", encoding="utf-8") as f:
                testcase_path = pathlib.Path(new_file_loc)
                # print("testcase_path: ", testcase_path)
                f.write(testcase_context)
            tmp = ThreadLock(testbed_location=testbed_location, testcase_path=testcase_path, testbed_id=testbed_id)
            threads_pool.append(tmp)
            tmp.start()
        for thread in threads_pool:
            thread.join()
            if thread.returnInfo:
                gc.collect()
            elif thread.output is not None:
                outputs.append(thread.output)
        return outputs

    # def single_thread(self, testcase_path: pathlib.Path)-> List[Output]:
    def single_thread(self, testcase_classname: str, testcase_context: str) -> List[Output]:
        outputs = []
        for engine in self.engines:
            testbed_id = engine[0]
            testbed_location = engine[1]
            jvm_name = testbed_location.split("/")[3]
            print(jvm_name)
            # new_classname = testcase_classname + "_" + jvm_name
            with open(code_files + jvm_name + "/" + testcase_classname + ".java", "w", encoding="utf-8") as f:
                testcase_path = pathlib.Path(code_files + jvm_name + "/" + testcase_classname + ".java")
                print(testcase_path)
                f.write(testcase_context)
                # testcase_context = testcase_context.replace(testcase_classname,new_classname,1)
                # print(testcase_context)
                tmp = ThreadLock(testbed_location=testbed_location, testcase_path=testcase_path, testbed_id=testbed_id)
                output = tmp.run()
                outputs.append(output)

        return outputs

    def compile_single_engine(self, class_name: str, testcase_context: str, want_testbed_id,
                              want_testbed_location="") -> List[Output]:
        # print("runhere")
        print("use engine:", self.engines)
        outputs = []
        threads_pool = []
        for engine in self.engines:
            if engine[0] == want_testbed_id:
                testbed_id = engine[0]
                if want_testbed_location != "":
                    testbed_location = want_testbed_location
                else:
                    testbed_location = engine[1]
                print(testbed_location)
                jvm_name = testbed_location.split("/")[3]
                new_file_loc = code_files + jvm_name + "/" + class_name + ".java"
                print("new_file_loc: ", new_file_loc)
                with open(new_file_loc, "w", encoding="utf-8") as f:
                    testcase_path = pathlib.Path(new_file_loc)
                    print(testcase_path)
                    f.write(testcase_context)
                tmp = ThreadLock(testbed_location=testbed_location, testcase_path=testcase_path, testbed_id=testbed_id)
                threads_pool.append(tmp)
                tmp.start()
        for thread in threads_pool:
            thread.join()
            if thread.returnInfo:
                gc.collect()
            elif thread.output is not None:
                outputs.append(thread.output)
        return outputs

    def compile_single_engine2(self, class_name: str, testcase_context: str, want_testbed_location, mm) -> List[Output]:
        outputs = []
        threads_pool = []
        # code_files = "/tmp/comfort_jvm_cov/" + str(mm) + "/"
        code_files = os.path.join(code_files_cov, str(mm))
        jvm_name = want_testbed_location.split("/")[3]
        new_file_loc = os.path.join(code_files, jvm_name) + "/" + class_name + ".java"
        print("new_file_loc: ", new_file_loc)
        with open(new_file_loc, "w", encoding="utf-8") as f:
            testcase_path = pathlib.Path(new_file_loc)
            # print(testcase_path)
            f.write(testcase_context)
        tmp = ThreadLock(testbed_location=want_testbed_location, testcase_path=testcase_path, testbed_id=-1, mm=mm)
        tmp.isCov = True
        threads_pool.append(tmp)
        tmp.start()
        for thread in threads_pool:
            thread.join()
            if thread.returnInfo:
                gc.collect()
            elif thread.output is not None:
                outputs.append(thread.output)
        return outputs
