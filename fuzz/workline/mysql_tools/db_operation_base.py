import pymysql

sql_config = dict(host='127.0.0.1',
                #   port=8888,
                  port=10348,
                  user='root',
                  passwd='mysql123',
                  # db='comfort',
                  db='JVMFuzzingData',
                  charset='utf8mb4')


class DataBaseHandle(object):
    """Define a class for MYSQL database operations."""

    def __init__(self):
        """Initialize database information and establish a connection."""
        self.conn = sql_config

    def createTable(self, sql):
        conn = pymysql.connect(**self.conn)
        cur = conn.cursor()
        cur.execute(sql)
        cur.close()
        conn.close()

    def selectOne(self, sql, prames):
        conn = pymysql.connect(**self.conn)

        cur = conn.cursor()
        # Present the query data result in the form of a dictionary.
        cur.execute(sql, prames)
        # Match a single data entry.
        data = cur.fetchone()
        cur.close()
        conn.close()
        return data  # Return the data obtained from executing the SQL statement, commonly used for querying.

    # Query all data.
    def selectall(self, sql):
        conn = pymysql.connect(**self.conn)

        cur = conn.cursor()
        cur.execute(sql)
        data = cur.fetchall()
        cur.close()
        conn.close()
        return data


    def selectmany(self, sql, prames):
        conn = pymysql.connect(**self.conn)

        cur = conn.cursor()
        cur.execute(sql, prames)

        data = cur.fetchmany()
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
