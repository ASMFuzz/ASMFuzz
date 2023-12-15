import sys
from pathlib import Path

BASE_DIR = str(Path(__file__).resolve().parent.parent)
sys.path.append(BASE_DIR)

from src.studyMysql.Table_Operation import Table_Suspicious_Result,Table_Result,Table_Testcase

table_SResult = Table_Suspicious_Result()
list_result = table_SResult.selectIdFromTablejavacSuspiciousResult(1)
print(list_result)


diff_res = []
for i in list(list_result):
    diff_res.append(list(i))
#print(diff_res)
def rule1():
    filter = []
    stderr = "java.lang.OutOfMemoryError: Requested array size exceeds VM limit\n\tat"
    table_result = Table_Result()
    for line in diff_res:
        res = table_result.selectByTestcaseIDFromTableResult(line[2])
        print(res)
        if res != None and res[5] != None and stderr in res[5]:
            filter.append(res[1])
        #print(filter)
    print(len(filter))
    filter = set(filter)
    print(len(filter))
    testbed = [3,4]
    err_type = 'Majority Java engines throw runtime error/exception'
    for res in diff_res:
        print(res != None)
        print(res[4] in testbed)
        print(res[1] == err_type)
        print(res[2] in filter) #false
        if res != None and res[4] in testbed and res[1] == err_type and res[2] in filter:
            with open("/root/Comfort_all/workline/filter.txt","a+",encoding="utf-8")as f:
                f.write(str(res[0])+" "+str(res[2]))
                f.write("\n")

def rule2():
    filter = []
    unfilter = []
    empty = []
    #stderr1 = 'Exception in thread "main" java.lang.IndexOutOfBoundsException'
    stderr2 = 'Exception in thread "main" java.lang.OutOfMemoryError'
    #err_type = ['crash','Most Java engines pass','Majority Java engines throw runtime error/exception']
    #stat1 = "import java.util.concurrent.atomic.AtomicIntegerArray;"
    stat2 = "static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);"
    stat3 = "static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);"
    stat4 = "static AtomicLongArray a = new AtomicLongArray(aParam1);"
    stat5 = "static AtomicLongArray b = new AtomicLongArray(bParam1);"
    table_result = Table_Result()
    table_testcase = Table_Testcase()
    TestcaseIDs=set()
    for line in diff_res[23:]:
        if line[2] in TestcaseIDs:
            continue
        else:
            TestcaseIDs.add(line[2])
        res = table_result.selectByTestcaseIDFromTableResult(line[2])
        context = table_testcase.selectOneContextFromTestcaseContent(line[2])[0]
        print(res)
        #print(context)
        if res == ():
            empty.append(line[0])
        elif (stat2 in context and stat3 in context) or (stat4 in context and stat5 in context):
            flag = False
            for r in res:
                if (r[5] != None and stderr2 in r[5] and r[3] == 1) or (r[3] == -9):
                    flag = False
                else:
                    flag = True
                    break
            if flag == True:
                unfilter.append(line[0])
            else:
                filter.append(line[0])
        else:
            unfilter.append(line[0])
    print(len(filter),len(unfilter),len(empty))
    print(filter)
    print(unfilter)
    print(empty)
rule2()



