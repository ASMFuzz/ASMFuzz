import os
import re

from src.studyMysql.Table_Operation import Table_Testcase

class EnergyUpdate:
    result = {}
    obj = Table_Testcase()
    id_List = []
    con_list = []
    name_list = []
    Mutation_Method = 0
    dir = "/JVMfuzzing/wy/data/test"+str(Mutation_Method)+"/"

    def setMm(self,val):
        self.Mutation_Method = val
        self.dir = "/JVMfuzzing/wy/data/test"+str(val)+"/"

    def update(self):
        self.getId(self.Mutation_Method)
        self.getMutator(dir)
        self.calcu()
        self.write2DB()

    def getId(self):
        res1 = self.obj.selectTestcaseIdFromTable("Table_Suspicious_Result",None)
        res2 = self.obj.selectTestcaseIdFromTable("Table_Testcase",self.Mutation_Method)
        res1_list = []
        res2_list = []
        for r in res1:
            if res1_list.__contains__(r[0]):
                continue
            res1_list.append(r[0])
        for r in res2:
            if res2_list.__contains__(r[0]):
                continue
            res2_list.append(r[0])
        for r in res1_list:
            if res2_list.__contains__(r):
                self.id_List.append(r)

        for id in self.id_List:
            res = self.obj.selectOneFromTableTestcase(id)
            # print(res[0])
            self.con_list.append(res[1])
        for con in self.con_list:
            name = self.searchName(con)
            self.name_list.append(name)

    def searchName(self,con):
        pattern = r"(public class )(MyJVMTest_[\d]*?)(?=(\s{)|{)"
        name = re.search(pattern, con).group(2)
        print(name)
        return name

    def getMutator(self):
         mutator_list = ""
         for name in self.name_list:
            file = self.dir+name+".txt"
            print(file)
            with open(file,"r") as f:
                mutator_info = f.read()
                temp = mutator_info.strip()[1:-2]
                mutator_list = temp.split(', ')
                print(mutator_list)

    def write2DB(self):
        if self.result.size()==0:
            return

if __name__== "__main__" :
    obj = EnergyUpdate()
    Mutation_method = 5
    obj.setMm(Mutation_method)
    obj.getId()
    obj.getMutator()
