import os, sys, json

from pathlib import Path
current_file_path = Path(__file__).resolve()
# print(current_file_path.parent.parent)
# print(type(current_file_path.parent.parent))
sys.path.append(str(current_file_path.parent.parent))
ROOT_DIR = current_file_path.parent.parent.parent.parent
BASE_DIR = str(Path(__file__).resolve().parent.parent)
from workline.Counter import Counter
from workline.Energy import Energy
from src.studyMysql.Table_Operation import Table_Result, Table_Testcase

LIST1 = []

class TestcaseToDB():
    def __init__(self,dir) -> None:
        self.dir = dir

    def writeToDB(self, num):
        listTemp = []
        table_Testcase = Table_Testcase()
        for root, dirs, files in os.walk(self.dir):
            print(self.dir)
            for file in files:
                print(file)
                if not file.endswith('.java'):
                    continue
                with open(self.dir + file, 'r') as f:
                    content = f.read()
                    listTemp.append(content)
        # return listTemp
        testcases_list_to_write = self.makeTestcasesListToWrite(listTemp, 0, 0, 0, num, 0, 0, 0, None)
        table_Testcase.insertManyDataToTableTestcase(testcases_list_to_write)

    def makeTestcasesListToWrite(self, all_testcases, SourceFun_id, SourceTestcase_id, Fuzzing_times,
                             Mutation_method, Mutation_times, Interesting_times, Probability, Remark) -> list:

        lis = []
        for testcase in all_testcases:
            Testcases_content = testcase
            item = [Testcases_content, SourceFun_id, SourceTestcase_id, Fuzzing_times, Mutation_method,
                    Mutation_times, Interesting_times, Probability, Remark]
            lis.append(item)
        return lis

class AddExports():
    def __init__(self, jdkdir, exportdir) -> None:
        self.jdkdir = jdkdir
        self.exportdir = exportdir

    def addExports(self):
        list2 = self.jdkdir.split('/')
        name = list2[len(list2) - 1]
        self.getAdd(name,self.jdkdir)
        list2 = LIST1[1:]
        end = "=ALL-UNNAMED"
        # javac
        start = "--add-exports=java.base/"
        with open(self.exportdir , "a+") as f:
            for l in list2:
                print(start + l + end)
                f.write(start + l + end + "\n")

    def getAdd(self, name, dir):
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
                if not LIST1.__contains__(name):
                    LIST1.append(name)
                break
            for d in dirs:
                if not LIST1.__contains__(name):
                    LIST1.append(name)
                self.getAdd(name + "." + d, dir + '/' + d)

    def watchAddExports(self):
        with open(self.exportdir,"r") as f:
            res = f.readlines()
            cmd = []
            for s in res:
                if s != '':
                    cmd.append(s[:-1])
                print(cmd)

class compareCoverage():
    def __init__(self) -> None:
        pass
    #3.2 After parsing two HTML directories (HtmlFile${NUM}) twice, the files analyse1.txt and analyse2.txt are generated. Compare to determine if new coverage has been generated.
    # Extracting file information.
    def get_file_info(self, lines, prefix):
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
    
    #get new coverage
    #params:test1f and test2f are the results obtained by reading from the HTML directory after two coverage tests, which are the second argument of analyseHtmls.
    def get_new_coverage(self, test1f, test2f, prefix):
        # Read files test1 and test2.
        with open(test1f, 'r') as f1:
            test1 = f1.readlines()
        with open(test2f, 'r') as f2:
            test2 = f2.readlines()
        test1_files = self.get_file_info(test1,prefix)
        test2_files = self.get_file_info(test2,prefix)

        # Compare file information to determine if test2 has discovered any new files/lines/branches not found in test1.
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



def run_testcaseToDB_main():
    # 1. Store test cases in the database in bulk, preparing for differential testing.
    # dir = '/root/shannonfuzz-getfeature/feature/src/test/output/target_test/0/'
    dir = os.path.join(ROOT_DIR,"shannonfuzz-getfeature/feature/src/test/output/target_test/1/")
    testcasetodb = TestcaseToDB(dir)
    testcasetodb.writeToDB(0)

def run_addExports_main():
    jdkdir = "/root/jvm/openjdk11/jdk-11.0.17+8/test/jdk/sun"
    # jdkdir = "/root/jvm/openjdk11/jdk-11.0.17+8/src/java.base/share/classes/jdk/internal"
    export_dir = "/root/shannonfuzz-python/fuzz/data/addExports.txt"
    addexports = AddExports(jdkdir,export_dir)
    # addexports.addExports()
    addexports.watchAddExports()

def run_energyupdate_main():
    obj = Energy()
    # 3.1.1 Calculate the execution frequency for each triggered line and branch recorded in the file based on analyse1.txt.
    test1f = os.path.join(BASE_DIR, "data/entropyData/analyse1.txt")
    # prefix = os.path.join(BASE_DIR, "data/entropyData/HtmlFile3")
    c2 = obj.get_frequency(test1f)

    # 3.1.2 Calculate entropy based on the Counter results.
    energy = obj.get_energy(c2)
    # print(energy)

    # 3.1.3 Recursively traverse the test9_1 directory (including subdirectories) [val_dir], read the specified [Mutation_method] related mutation operator database and ID numbers for testing purposes.
    # obj.val_dir = "/JVMfuzzing/wy/test1/"
    obj.val_dir = "/root/shannonfuzz-getfeature/feature/src/test/output/target_test"
    obj.Mutation_method = 1
    all_files = obj.read_mutators_fromDir()
    # print("files_data: ",all_files)
    # print("files_data[1]: ",all_files["1"])
    # print("files_data[1]keys: ",all_files["1"].keys())

    mutator_file = "/root/shannonfuzz-getfeature/feature/src/test/output/target_test/0/MyJVMTest_201363.txt"
    name,files_data = obj.read_mutator(mutator_file)
    files_data = {name:files_data}
    # print(files_data)

    # 3.1.4 Write back the entropy values to the mutation operator database 'energy'.
    print("All Data: ", all_files, files_data, energy)
    # obj.write_energy(all_files["1"], files_data , energy)

def run_compareCoverage_main():
    comparecoverage = compareCoverage()
    test1f="/root/shannonfuzz-python/fuzz/data/entropyData/analyse1.txt"
    test2f="/root/shannonfuzz-python/fuzz/data/entropyData/analyse2.txt"
    prefix = "/root/shannonfuzz-python/fuzz/data/entropyData/HTMLFileJT3"
    newFile,newLines,newBranches = comparecoverage.get_new_coverage(test1f,test2f,prefix)
    print("newFile: ", newFile)
    print("newLines: ", newLines)
    print("newBranches: ", newBranches)


if __name__=='__main__':
    # 1. Bulk import test cases into the testcase database for differential testing preparation.
    run_testcaseToDB_main()

    # 2. Auto complete addExports.
    # run_addExports_main()

    # 3. Update the information entropy of a single file.
    # run_energyupdate_main()

    # 4. Compare file information to determine if test2 has discovered new files/lines/branches that test1 did not discover.
    # run_compareCoverage_main()