#!/usr/bin/env python
# coding=utf-8
import json
import os
import shutil
import subprocess
import sys
import time
# os.chdir(os.path.dirname(__file__))
from os.path import abspath

from utils.config import Hparams_Coverage


# env_dist = os.environ
# print(env_dist)

def coverage(report_dir, temp_dir, file_path):
    # calculate the coverage of simple file and report the total coverage
    # print(file_path)
    cmd = ["timeout", "-s9", "10s", "nyc",
           "--reporter=json-summary", "--cache=false", "--report-dir=" + report_dir, "--temp-dir=" + temp_dir,
           "--clean=false", "node", file_path]
    # cmd = [ "nyc"]

    # p = subprocess.Popen(cmd, stdout=subprocess.PIPE, stderr=subprocess.PIPE)

    if sys.platform.startswith('win'): 
        p = subprocess.Popen(cmd, stdout=subprocess.PIPE, shell=True)
    else:
        # p1 = subprocess.Popen(cmd, stdout=subprocess.PIPE)
        p = subprocess.Popen(cmd, stdout=subprocess.PIPE, stderr=subprocess.PIPE)

    stdout, stderr = p.communicate()


def jshint_checking(file_path):
    # cmd = ['timeout', '60s', 'node', '--max_old_space_size=4096', 'jshint']
    cmd = ['timeout', '60s', 'jshint', '-c', '/root/Comfort_all/data/.jshintrc',file_path]

    if sys.platform.startswith('win'): 
        p1 = subprocess.Popen(cmd, stdout=subprocess.PIPE, shell=True)
    else: 
        p1 = subprocess.Popen(cmd, stdout=subprocess.PIPE, stderr=subprocess.PIPE)

    stdout, stderr = p1.communicate()
    if stdout:
        print(f"{file_path} Syntax error")
        print(stdout)
    if stderr:
        print("error")
        print(stderr)

    stdout = p1.communicate()[0]
    if stdout.__len__() > 0:
        jshint_flag = 0
    else:
        jshint_flag = 1
    return jshint_flag


def extractCoverage(coverage_file):
    with open(coverage_file, "r", encoding="utf-8") as f:
        content = f.read()
    coverage_message = json.loads(content)
    statement_cov = coverage_message['total']["statements"]['pct']
    function_cov = coverage_message['total']["functions"]['pct']
    branch_cov = coverage_message['total']["branches"]['pct']
    line_cov = coverage_message['total']["lines"]['pct']
    return [statement_cov, function_cov, branch_cov, line_cov]


def reset_dir(dir_path):
    if not os.path.exists(dir_path):
        os.mkdir(dir_path)
    else:
        shutil.rmtree(dir_path)
        os.mkdir(dir_path)


def copy_files(src, target):
    count = 1
    reset_dir(target)
    for root, dirs, files in os.walk(src):
        for file in files:
            count =count + 1
            src_file = os.path.join(root, file)
            shutil.copy(src_file, target)
    print(f"copy {count} files")


if __name__ == '__main__':
    hparams = Hparams_Coverage().parser.parse_args()

    parent_dir = "src/codeCoverage"
    reporter_dir = os.path.join(parent_dir, "reporter")
    fuzzer = hparams.fuzzer
    coverage_files = hparams.coverage_files

    if coverage_files:
        if os.path.isdir(coverage_files):
            corpus_dir = os.path.join(parent_dir, "self_defining_generate")
        else:
            print("please input the correct directory of test files")
            sys.exit(0)
    else:
        corpus_dir = os.path.join(parent_dir, fuzzer + "_generate")

    report_dir = os.path.join(parent_dir, "report")
    temp_dir = os.path.join(parent_dir, "nyc_output")
    reset_dir(report_dir)
    reset_dir(temp_dir)

    corpus_dir = hparams.coverage_files

    total = 0
    for root, dirs, files in os.walk(corpus_dir):
        for file in files:
            file_path = os.path.join(root, file)
            if file_path.endswith(".js"):
                total += 1

    i = 0
    jshint_pass = 0
    for root, dirs, files in os.walk(corpus_dir):
        for file in files:
            file_path = os.path.join(root, file)
            if file_path.endswith(".js"):
                process = "\rprocessing: {current}/{total}".format(current=str(i + 1), total=total)
                # 可以刷新的打印
                sys.stdout.write(process)
                print(file_path)
                coverage(report_dir, temp_dir, file_path)
                i += 1

    coverage_file = os.path.join(report_dir, "coverage-summary.json")

    now = time.localtime()
    nowt = time.strftime("%Y-%m-%d-%H_%M_%S", now)
    if not os.path.exists(reporter_dir):
        os.mkdir(reporter_dir)
    else:
        pass

    reporter_path = os.path.join(reporter_dir, nowt + "_" + fuzzer + ".json")
    with open(reporter_path, "w", encoding="utf-8") as f:
        f.write(open(coverage_file, "r").read())
    #
    coverages = extractCoverage(coverage_file)
    print("\ncoverage rate results:")
    print("statement coverages: %s" % coverages[0])
    print("function coverages: %s" % coverages[1])
    print("branch coverages: %s" % coverages[2])
    print("line coverages: %s" % coverages[3])
    print(f"\n------------------------------------------------------")
    print(f"Coverage messages has been saved to {reporter_path}'")
    print(f"------------------------------------------------------\n")
