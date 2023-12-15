import os
import subprocess

testcases_list = []
java_file_list = []
java_file_with_packageInfo_list = []
path = "/root/shannonfuzz-python/fuzz/data/testJDK/HotspotTests-Java"
testcases_file_path = path + "/testcases.txt"
src_path = path + "/src"
out_path = path + "/out"
testbed_location = "/root/jvm/openjdk11/jdk-11.0.14-ga/build/linux-x86_64-normal-server-release/images/jdk/bin/java"
compile_failed_testcases = []
run_failed_testcases = []


def Read_Testcases():
    with open(testcases_file_path, "r") as f:
        list1 = f.readlines()
    for line in list1:
        line = line.replace("\n", "")
        testcases_list.append(line)
    # print(testcases_list)
    print(len(testcases_list))


def Read_src_Testcases():
    for root, ds, fs in os.walk(src_path):
        for f in fs:
            if (f.endswith(".java")):
                # print(f)
                fullname = os.path.join(root, f)
                java_file_list.append(fullname)
                fileWithPackageInfoList = fullname.replace(src_path + "/", "").replace(".java", "").split("/")
                fileWithPackageInfo = ".".join(fileWithPackageInfoList)
                print(fullname)
                print(fileWithPackageInfo)
                java_file_with_packageInfo_list.append(fileWithPackageInfo)
    print(len(java_file_list))
    print(len(java_file_with_packageInfo_list))


def compile_Testcases(time):
    current = 0
    for f in java_file_list:
        current = current + 1
        javac_cmd = ["timeout", "-s9", str(time), testbed_location + "c", "-d", out_path]
        print(f)
        javac_cmd.append(f)
        print(javac_cmd)
        pro_javac = subprocess.Popen(javac_cmd, shell=False, universal_newlines=True, stdout=subprocess.PIPE,
                                     stderr=subprocess.PIPE)
        stdout, stderr = pro_javac.communicate()
        print(len(stderr), len(stdout), stderr, stdout)
        if pro_javac.returncode != 0:
            compile_failed_testcases.append(f)

        print("current: ", current)
        print("java_file_list: ", len(java_file_list))
        print("compile_failed_testcases: ", len(compile_failed_testcases))
        print("compile_failed_testcases rate: ", len(compile_failed_testcases) / len(java_file_list) * 100, "%")


def run_Testcases(time):
    currentRun = 0
    # / root / shannonfuzz - python / fuzz / data / testJDK / HotspotTests - Java / out
    for root, ds, fs in os.walk(out_path):
        for f in fs:
            if (f.endswith(".class")):
                fullname = f.replace(".class", "")
                # print(fullname)
                java_cmd = ["timeout", "-s9", str(time), testbed_location, "-cp", out_path]
                java_cmd.append(fullname)
                print(java_cmd)
                pro_java = subprocess.Popen(java_cmd, shell=False, universal_newlines=True, stdout=subprocess.PIPE,
                                             stderr=subprocess.PIPE)
                stdout, stderr = pro_java.communicate()
                print(len(stderr), len(stdout), stderr, stdout)
                if pro_java.returncode != 0:
                    run_failed_testcases.append(f)
                currentRun += 1
                print("current: ", currentRun)
                print("java_file_with_packageInfo_list", len(java_file_with_packageInfo_list))
                print("run_failed_testcases: ", len(run_failed_testcases))
                print("run_failed_testcases rate: ", len(run_failed_testcases) / len(java_file_with_packageInfo_list) * 100, "%")



Read_Testcases()
Read_src_Testcases()
# compile_Testcases(30)
run_Testcases(30)
print(len(compile_failed_testcases))
# ['timeout', '-s9', '30', '/root/jvm/openjdk11/jdk-11.0.14-ga/build/linux-x86_64-normal-server-release/images/jdk/bin/java', '-cp', '/root/shannonfuzz-python/fuzz/data/testJDK/HotspotTests-Java/out', 'nsk.sysdict.vm.stress.chain.chain004.chain004']
