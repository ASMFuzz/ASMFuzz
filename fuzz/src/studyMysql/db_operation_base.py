import threading

import pymysql

# sql_config = dict(host='127.0.0.1',
#                   port=3306,
#                   user='root',
#                   passwd='mysql123',
#                   # db='comfort',
#                   # db='Comfort_JVM',
#                    db='JVMFuzzingData',
#                   charset='utf8mb4')
sql_config = dict(host='10.15.0.35',
                  port=10348,
                  user='root',
                  passwd='mysql123',
                #   db='JVMFuzzingData',
                  db='experiment1',
                  charset='utf8mb4')


class DataBaseHandle(object):
    """Define a MySQL database operation class"""
    def __init__(self):
        """Initialize database information and establish a connection"""
        self.conn = sql_config
        self.mutex = threading.Lock()

    # Create table
    def createTable(self, sql):
        conn = pymysql.connect(**self.conn)
        cur = conn.cursor()
        cur.execute(sql)
        cur.close()
        conn.close()

    # Query single row: sql is the SQL statement, and prames is the parameter to be passed, which can be a tuple.
    def selectOne(self, sql, prames):
        conn = pymysql.connect(**self.conn)

        cur = conn.cursor()
        # Present the query data result in the form of a dictionary.
        self.mutex.acquire()
        cur.execute(sql, prames)
        self.mutex.release()
        # Match a single data record.
        data = cur.fetchone()
        cur.close()
        conn.close()
        return data  # Return the data obtained from executing the SQL statement. This is commonly used for querying.

    # Retrieve all data.
    def selectall(self, sql):
        conn = pymysql.connect(**self.conn)

        cur = conn.cursor()
        self.mutex.acquire()
        cur.execute(sql)
        self.mutex.release()
        # data = cur.fetchmany(number) receives 'number' of records and returns them
        # fetchall matches multiple data records
        data = cur.fetchall()
        cur.close()
        conn.close()
        return data

    # Retrieve multiple data records.
    def selectmany(self, sql, prames):
        conn = pymysql.connect(**self.conn)

        cur = conn.cursor()
        self.mutex.acquire()
        cur.execute(sql, prames)
        self.mutex.release()
        # Receive 'number' of records and return them.
        # data = cur.fetchmany()
        data = cur.fetchall()
        cur.close()
        conn.close()
        return data

    # Insert data.
    def insert(self, sql, prames):
        conn = pymysql.connect(**self.conn)
        cur = conn.cursor()
        recount = cur.execute(sql, prames)
        conn.commit()
        cur.close()
        conn.close()
        return recount

    # Insert multiple data records.
    def insertMany(self, sql, lis):
        conn = pymysql.connect(**self.conn)
        cur = conn.cursor()
        # executemany handles multiple data records at once.
        recount = cur.executemany(sql, lis)
        conn.commit()
        cur.close()
        conn.close()
        return recount

    # Delete data.
    def delete(self, sql, prames):
        conn = pymysql.connect(**self.conn)
        cur = conn.cursor()
        recount = cur.execute(sql, prames)
        conn.commit()
        cur.close()
        conn.close()
        return recount

    # Delete all data.
    def deleteAll(self, sql):
        conn = pymysql.connect(**self.conn)
        cur = conn.cursor()
        recount = cur.execute(sql)
        conn.commit()
        cur.close()
        conn.close()
        return recount

    # Update data.
    def update(self, sql, prames):
        conn = pymysql.connect(**self.conn)
        cur = conn.cursor()
        recount = cur.execute(sql, prames)
        conn.commit()
        cur.close()
        conn.close()
        return recount
