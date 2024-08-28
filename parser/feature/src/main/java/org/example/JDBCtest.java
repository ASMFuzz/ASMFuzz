package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCtest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection con;
        String driver="com.mysql.cj.jdbc.Driver";
        String url="jdbc:mysql://127.0.0.1:10348/asmfuzz?&useSSL=false&serverTimezone=UTC";
        String user="root";
        String password="root";
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            if (!con.isClosed()) {
                System.out.println("yes");
            }
            con.close();
        } catch (ClassNotFoundException e) {
            System.out.println("no jdbc");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("jdbc~error");
        }
    }
}
