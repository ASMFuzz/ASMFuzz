# -*- coding: utf-8 -*-
from loguru import logger
import numpy as np
from scipy import linalg
import time, sys
# export LC_ALL=C
from multiprocessing.dummy import Pool as ThreadPool
from pathlib import Path
import os

BASE_DIR = str(Path(__file__).resolve().parent.parent)
sys.path.append(BASE_DIR)
from src.studyMysql.Table_Operation import Table_Testcase, Table_Result
from workline.table_to_class.Table_Testcase import Testcase_Object
from workline.Energy import Energy
from workline.Coverage import Coverage
from workline.harness_tools.harness_class import Harness as H_java

table_Testcases = Table_Testcase()



class LinUCB:

    def __init__(self):
        self.alpha = 0.25
        self.r1 = 1
        self.r0 = 0
        self.d = 1
        self.Aa = {}
        self.AaI = {}
        self.ba = {}
        self.a_max = 0
        self.theta = {}
        self.x = None
        self.xT = None

    def set_articles(self, art):
        for key in art:
            self.Aa[key] = np.identity(self.d)
            self.ba[key] = np.zeros((self.d, 1))
            self.AaI[key] = np.identity(self.d)
            self.theta[key] = np.zeros((self.d, 1))
    def update(self, reward):
        if reward == -1:
            pass
        elif reward == 1 or reward == 0:
            if reward == 1:
                r = self.r1
            else:
                r = self.r0
            self.Aa[self.a_max] += np.dot(self.x, self.xT)
            self.ba[self.a_max] += r * self.x
            self.AaI[self.a_max] = linalg.solve(self.Aa[self.a_max], np.identity(self.d))
            self.theta[self.a_max] = np.dot(self.AaI[self.a_max], self.ba[self.a_max])
        else:
            pass

    def recommend(self,user_features, articles):
        xaT = np.array([user_features])
        xa = np.transpose(xaT)
        art_max = -1
        old_pa = 0
        AaI_tmp = np.array([self.AaI[article] for article in articles])
        theta_tmp = np.array([self.theta[article] for article in articles])
        art_max = articles[np.argmax(np.dot(xaT, theta_tmp) + self.alpha * np.sqrt(np.dot(np.dot(xaT, AaI_tmp), xa)))]
        self.x = xa
        self.xT = xaT
        self.a_max = art_max
        return self.a_max


def muti_javac_compile(testcase, isInsert=True):
    testcase_object = Testcase_Object(testcase)
    logger.info('*' * 25 + f'compile{testcase_object.Id}' + '*' * 25)

    Compiled_result = testcase_object.engine_compile_testcase()
    if isInsert:

        if Compiled_result != None:

            Compiled_result.save_to_table_result()

            different_result_list = Compiled_result.differential_test()

            if not len(different_result_list):
                logger.info("nothing happened.")
            else:
                logger.info("{}error has been occured by java compiler.".format(len(different_result_list)))

                for interesting_test_result in different_result_list:

                    interesting_test_result.save_to_table_suspicious_Result()
            logger.info(f'Spending time:{int(time.time() - start_time)}s')
            return different_result_list
        else:
            logger.info('*' * 25 + f'{testcase_object.Id} has no content.' + '*' * 25)
    return None


def check(testcase):
    testcase_object = Testcase_Object(testcase)
    counter = testcase_object.check_classfile()
    logger.info(f'{testcase_object.Id} classfiles has been made: ' + str(counter))

    return counter


def muti_harness(testcase, isInsert=True):
    testcase_object = Testcase_Object(testcase)
    counter = check(testcase)
    if counter == 0:
        print(f"{testcase_object.Id} no classfile found.")
        return
    logger.info('*' * 25 + f'running{testcase_object.Id}' + '*' * 25)
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
                logger.info("nothing happened.")

            else:
                logger.info("{}error has been occured by JVM.".format(len(different_result_list)))

                testcase_object.add_interesting_times(1)

                for interesting_test_result in different_result_list:

                    interesting_test_result.save_to_table_suspicious_Result()

        logger.info(f'Spending time:{int(time.time() - start_time)}s')

        testcase_object.updateFuzzingTimesInterestintTimes()


def run_javac_demo(list_unfuzzing):
    energy_list = []
    error_list = []
    for testcase in list_unfuzzing:
        try:
            start_time = time.time()
            error_new = muti_javac_compile(testcase)
            end_time = time.time()
            all_time = end_time - start_time

            linucb = LinUCB()
            art = [1, 2]
            linucb.set_articles(art)
            user_features = np.array([all_time])
            recommended_article = linucb.recommend(user_features=user_features)
            if recommended_article == 1:
                energy_test = True

            logger.info(f'take {int(end_time - start_time)}s second. ')
            # logger.info(list_unfuzzing)

            if energy_test:
                get_coverage(testcase)
                energy = get_energy(ana_path)
                energy_list.append(energy)
                os.unlink(ana_path)
            else:
                error_list.append(error_new)

            if not len(error_new):
                reward = -1
                linucb.update(reward)
            else:
                reward = 1
                linucb.update(reward)

        except Exception as e:
            logger.warning("muti_javac_compile catch Exception:")
            logger.warning(e)

        file_counter = check(testcase)
        if file_counter == 0:
            logger.info("update insteresting times to -1")

            faile_compiler(testcase=testcase)
        elif file_counter != 9:
            logger.info("incorrect file count: ", file_counter)

        elif file_counter == 9:
            logger.info("incorrect file count: ", file_counter)
            muti_harness(testcase)

def faile_compiler(testcase):
    testcase_object = Testcase_Object(testcase)
    testcase_object.failcompiler_interesting()
    testcase_object.updateFuzzingTimesInterestintTimes()


def get_coverage(testcase):

    harness = H_java()
    Testcase_id = testcase[0]
    Testcase_context = testcase[1]
    mm = 33
    want_testbed_location = '/root/jdk_cov/jdk11u-dev/build/linux-x86_64-normal-server-release/jdk/bin/java'

    if Testcase_context != "":

        harness.get_class_name(Testcase_context)
        harness_result = harness.run_testcase_single_engine_cov(want_testbed_location,mm)

    else:
        print(f"{Testcase_id} has no content.")

    os.system(
        "cd /root/jdk_cov/jdk11u-dev/build/linux-x86_64-normal-server-release/hotspot/variant-server/libjvm/objs&&lcov -b ./ -d ./ --rc lcov_branch_coverage=1 --gcov-tool /usr/bin/gcov-7 -c -o output.info&&genhtml --rc genhtml_branch_coverage=1 --rc geninfo_gcov_all_blocks=0 -o ../HtmlFile output.info|tee result.txt")

    delect_gcda = os.system(
        "cd /root/jdk_cov/jdk11u-dev/build/linux-x86_64-normal-server-release/hotspot/variant-server/libjvm/objs&&find . -name '*.gcda' | xargs -i rm -f {}")

    html_root_dir = '/root/jdk_cov/jdk11u-dev/build/linux-x86_64-normal-server-release/hotspot/variant-server/libjvm/HtmlFile'
    analyse_output_path = '/root/asmfuzz/workline/data/analyse/analyse.txt'
    cov_obj = Coverage()
    cov_obj.analyseHtmls(html_root_dir, analyse_output_path)

    os.system("rm -r "+html_root_dir)


def get_energy(ana_path):
    obj = Energy()

    test1f = ana_path

    c2 = obj.get_frequency(test1f)

    energy = obj.get_energy(c2)
    return energy


if __name__ == '__main__':
    ana_path = "/root/asmfuzz/workline/data/analyse/analyse.txt"
    list_unfuzzing = table_Testcases.selectAllNeedTestFromTestcase()

    start_time = time.time()
    run_javac_demo(list_unfuzzing)
    end_time = time.time()
    all_time = end_time - start_time