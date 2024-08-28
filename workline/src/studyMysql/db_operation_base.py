import threading
import pymysql


sql_config = dict(host='127.0.0.1',
                  port=10348,
                  user='root',
                  passwd='root',
                  db='asmfuzz',
                  charset='utf8mb4')


class DataBaseHandle(object):

    def __init__(self):
        self.conn = sql_config
        self.mutex = threading.Lock()

    def createTable(self, sql):
        conn = pymysql.connect(**self.conn)
        cur = conn.cursor()
        cur.execute(sql)
        cur.close()
        conn.close()

    def selectOne(self, sql, prames):
        conn = pymysql.connect(**self.conn)

        cur = conn.cursor()
        self.mutex.acquire()
        cur.execute(sql, prames)
        self.mutex.release()
        data = cur.fetchone()
        cur.close()
        conn.close()
        return data 


    def selectall(self, sql):
        conn = pymysql.connect(**self.conn)
        cur = conn.cursor()
        self.mutex.acquire()
        cur.execute(sql)
        self.mutex.release()
        data = cur.fetchall()
        cur.close()
        conn.close()
        return data

    def selectmany(self, sql, prames):
        conn = pymysql.connect(**self.conn)

        cur = conn.cursor()
        self.mutex.acquire()
        cur.execute(sql, prames)
        self.mutex.release()
        data = cur.fetchall()
        cur.close()
        conn.close()
        return data

    def insert(self, sql, prames):
        conn = pymysql.connect(**self.conn)

        cur = conn.cursor()
        recount = cur.execute(sql, prames)
        conn.commit()
        cur.close()
        conn.close()
        return recount

    def insertMany(self, sql, lis):
        conn = pymysql.connect(**self.conn)

        cur = conn.cursor()
        recount = cur.executemany(sql, lis)
        conn.commit()
        cur.close()
        conn.close()
        return recount

    def delete(self, sql, prames):
        conn = pymysql.connect(**self.conn)

        cur = conn.cursor()
        recount = cur.execute(sql, prames)
        conn.commit()
        cur.close()
        conn.close()
        return recount

    def deleteAll(self, sql):
        conn = pymysql.connect(**self.conn)

        cur = conn.cursor()
        recount = cur.execute(sql)
        conn.commit()
        cur.close()
        conn.close()
        return recount

    def update(self, sql, prames):
        conn = pymysql.connect(**self.conn)

        cur = conn.cursor()
        recount = cur.execute(sql, prames)
        conn.commit()
        cur.close()
        conn.close()
        return recount
