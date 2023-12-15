from workline.mysql_tools.db_operation_base import DataBaseHandle

class Table_Function(object):
    def __init__(self):
        self.__table = DataBaseHandle()

    def selectOneFromTableFunction(self, id):
        sql = 'select * from Table_Function where id=%s'
        prames = (id)
        return self.__table.selectOne(sql, prames)

    def selectIdFromTableFunction(self, id):
        sql = f'select * from Table_Function where id={id}'
        return self.__table.selectall(sql)

    def selectSourceIdFromTableFunction(self, SourceFun_id):
        sql = f'select * from Table_Function where SourceFun_id={SourceFun_id}'
        return self.__table.selectall(sql)

    def selectFromTableFunctionForNumber(self, id, number):
        sql = 'select * from Table_Function where id=%s limit %s'
        prames = (id, number)
        return self.__table.selectmany(sql, prames)

    def selectAllFromTableFunction(self):
        sql = 'select * from Table_Function'
        return self.__table.selectall(sql)

    def insertDataToTableFunction(self, Function_Content, SourceFun_Id, Mutation_Method, Remark):
        sql = 'INSERT INTO Table_Function(Function_content,SourceFun_id,Mutation_method,Remark) values(%s,%s,%s,%s)'
        prames = (Function_Content, SourceFun_Id, Mutation_Method, Remark)
        return self.__table.insert(sql, prames)

    def insertManyDataToTableFunction(self, lis):
        sql = 'insert into Table_Function(Function_content,SourceFun_id,Mutation_method,Mutation_times,Remark) values(%s,%s,%s,%s,%s)'
        return self.__table.insertMany(sql, lis)

    def deleteFromTableFunction(self, id):
        sql = 'delete from Table_Function where id=%s'
        prames = (id,)
        return self.__table.delete(sql, prames)

    def deleteAllFromTableFunction(self):
        sql = 'delete from Table_Function'
        return self.__table.deleteAll(sql)

    def updateDataBaseHandle(self, id, Function_content):
        sql = 'update Table_Function set Function_content= %s where id = %s'
        prames = (Function_content, id)
        return self.__table.update(sql, prames)

    def updateMutationTimes(self, MutationTimes, id):
        sql = 'update Table_Function set Mutation_times= %s where id = %s'
        prames = (MutationTimes, id)
        return self.__table.update(sql, prames)

    def selectMutationTimesFromTableFunction(self, Mutation_Times, SourceFun_id):
        sql = f'select * from Table_Function where Mutation_times={Mutation_Times} AND SourceFun_id = {SourceFun_id} '
        return self.__table.selectall(sql)


class Table_Testcase(object):

    def __init__(self):
        # 实例化 DataBaseHandle()
        self.__table = DataBaseHandle()

    def selectOneFromTableTestcase(self, id):
        sql = 'select * from Table_Testcase where id=%s'
        prames = (id)
        return self.__table.selectOne(sql, prames)

    def selectIdFromTableTestcase(self, id):
        sql = f'select * from Table_Testcase where Id={id}'
        return self.__table.selectall(sql)

    def selectInterestingTimeFromTableTestcase(self, Interesting_times):
        sql = f'select * from Table_Testcase where Interesting_times={Interesting_times}'
        return self.__table.selectall(sql)

    def selectFuzzingTimeFromTableTestcase(self, Fuzzing_times):
        sql = f'select * from Table_Testcase where Fuzzing_times={Fuzzing_times}'
        return self.__table.selectall(sql)

        # return self.__table.selectOne(sql, prames)

    def selectFromTableTestcaseForNumber(self, id, number):
        sql = 'select * from Table_Testcase where id=%s limit %s'
        prames = (id, number)
        return self.__table.selectmany(sql, prames)

    def selectAllFromTableTestcase(self):
        sql = 'select * from Table_Testcase'
        return self.__table.selectall(sql)

    def insertDataToTableTestcase(self, Testcase_context, SourceFun_id, SourceTestcase_id, Fuzzing_times,
                                  Mutation_method, Mutation_times, Interesting_times, Probability, Remark):
        sql = 'INSERT INTO Table_Testcase(Testcase_context, SourceFun_id, SourceTestcase_id, Fuzzing_times,Mutation_method ,Mutation_times,Interesting_times,Probability,Remark) values(%s,%s,%s,%s,%s,%s,%s,%s,%s)'
        prames = (Testcase_context, SourceFun_id, SourceTestcase_id, Fuzzing_times, Mutation_method, Mutation_times,
                  Interesting_times, Probability, Remark)
        return self.__table.insert(sql, prames)

    def insertManyDataToTableTestcase(self, lis):
        sql = 'INSERT INTO Table_Testcase(Testcase_context, SourceFun_id, SourceTestcase_id, Fuzzing_times,Mutation_method ,Mutation_times,Interesting_times,Probability,Remark) values(%s,%s,%s,%s,%s,%s,%s,%s,%s)'
        return self.__table.insertMany(sql, lis)

    def deleteFromTableTestcase(self, id):
        sql = 'delete from Table_Testcase where id=%s'
        prames = (id,)
        return self.__table.delete(sql, prames)

    def deleteAllFromTableTestcase(self):
        sql = 'delete from Table_Testcase'
        return self.__table.deleteAll(sql)

    def updateDataBaseHandle(self, id, Function_content):
        sql = 'update Table_Testcase set Testcase_context= %s where id = %s'
        prames = (Function_content, id)
        return self.__table.update(sql, prames)

    def updateFuzzingTimesInterestintTimes(self, Fuzzing_times, Interesting_times, id):
        sql = 'update Table_Testcase set Fuzzing_times= %s ,Interesting_times = %s where id = %s'
        prames = (Fuzzing_times, Interesting_times, id)
        return self.__table.update(sql, prames)

    def updateMutationTimes(self, MutationTimes, id):
        sql = 'update Table_Testcase set Mutation_times= %s where id = %s'
        prames = (MutationTimes, id)
        return self.__table.update(sql, prames)


class Table_Result(object):

    def __init__(self):
        self.__table = DataBaseHandle()

    def selectTestcasesFromTableResult(self, Testcase_id):
        sql = f'select * from Table_Result where Testcase_id={Testcase_id}'
        return self.__table.selectall(sql)

    def selectAllFromTableResult(self):
        sql = 'select * from Table_Result'
        return self.__table.selectall(sql)

    def insertDataToTableResult(self, Testcase_Id, Testbed_Id, Returncode, Stdout, Stderr, duration_ms, seed_coverage,
                                engine_coverage, Remark):
        sql = 'INSERT INTO Table_Result(Testcase_Id, Testbed_Id, Returncode, Stdout,Stderr ,duration_ms,seed_coverage,engine_coverage,Remark) values(%s,%s,%s,%s,%s,%s,%s,%s,%s)'
        prames = (
            Testcase_Id, Testbed_Id, Returncode, Stdout, Stderr, duration_ms, seed_coverage, engine_coverage, Remark)
        return self.__table.insert(sql, prames)

    def insertManyDataToTableResult(self, lis):
        sql = 'INSERT INTO Table_Result(Testcase_Id, Testbed_Id, Returncode, Stdout,Stderr ,duration_ms,seed_coverage,engine_coverage,Remark) values(%s,%s,%s,%s,%s,%s,%s,%s,%s)'
        return self.__table.insertMany(sql, lis)

    def deleteFromTableResult(self, id):
        sql = 'delete from Table_Result where id=%s'
        prames = (id,)
        return self.__table.delete(sql, prames)

    def deleteAllFromTableResult(self):
        sql = 'delete from Table_Result'
        return self.__table.deleteAll(sql)

    def updateDataBaseHandle(self, id, Function_content):
        sql = 'update Table_Result set Testcase_context= %s where id = %s'
        prames = (Function_content, id)
        return self.__table.update(sql, prames)


class Table_Testbed(object):

    def __init__(self):
        self.__table = DataBaseHandle()

    def selectAllFromTableTestbed(self):
        sql = 'select * from Table_Testbed'
        return self.__table.selectall(sql)

    def selectAllIdAndLocateFromTableTestbed(self):
        sql = 'select Id,Testbed_location from Table_Testbed'
        return self.__table.selectall(sql)


class Table_Suspicious_Result(object):

    def __init__(self):
        self.__table = DataBaseHandle()

    def insertDataToTableSuspiciousResult(self, Error_type, Testcase_id, Function_id, Testbed_id, Remark, Is_filtered):
        sql = 'INSERT INTO Table_Suspicious_Result( Error_type, Testcase_id, Function_id, Testbed_id,  Remark,Is_filtered) values(%s,%s,%s,%s,%s,%s)'
        prames = (Error_type, Testcase_id, Function_id, Testbed_id, Remark, Is_filtered)
        return self.__table.insert(sql, prames)

    def selectErrorTypeFromTableFunction(self, ErrorType):
        sql = f"select * from Table_Suspicious_Result where Error_type={ErrorType} ORDER BY Testcase_id"
        return self.__table.selectall(sql)

    def selectErrorTypeUnfilteredFromTableFunction(self, ErrorType):
        sql = f"select * from Table_Suspicious_Result where Error_type={ErrorType} And Is_filtered='0' ORDER BY Testcase_id"
        return self.__table.selectall(sql)

    def selectIdFromTable_Suspicious_Result(self, id):
        sql = f'select * from Table_Suspicious_Result where Id={id}'
        return self.__table.selectall(sql)

    def selectTestcseIdFromTable_Suspicious_Result(self, Testcase_id):
        sql = f'select * from Table_Suspicious_Result where Testcase_id={Testcase_id}'
        return self.__table.selectall(sql)

    def selectUnFilteredFromTable_Suspicious_Result_with_error_type(self, error_type):
        sql = f"select * from Table_Suspicious_Result where Is_filtered='0' AND error_type = {error_type}"
        return self.__table.selectall(sql)

    def selectUnFilteredFromTable_Suspicious_Result(self):
        sql = f"select * from Table_Suspicious_Result where Is_filtered='0'"
        # sql = f"select * from Table_Suspicious_Result where Is_filtered='0' LIMIT 0,50"
        return self.__table.selectall(sql)

    def updateIs_filtered(self, id, Is_filtered):
        sql = 'update Table_Suspicious_Result set Is_filtered= %s where id = %s'
        prames = (Is_filtered, id)
        return self.__table.update(sql, prames)