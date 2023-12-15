from db_operation_base import DataBaseHandle


def select_one_from_table(id:int):
    db = DataBaseHandle()
    sql = 'select * from API_Info where id=%s'
    prames = (id)
    return db.selectOne(sql, prames)

def select_all_from_table():
    db = DataBaseHandle()
    sql = 'select * from API_Info'
    return db.selectall(sql)

def insert_many_data_into_table(sql, lis):
    db = DataBaseHandle()
    # sql = 'insert into API_Info(Class_Name,Constructor_Stmt,Class_URL) values(%s,%s,%s)'
    return db.insertMany(sql, lis)
