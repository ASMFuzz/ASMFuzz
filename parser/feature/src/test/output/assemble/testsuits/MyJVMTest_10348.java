import java.sql.SQLException;

public class MyJVMTest_10348 {

    static Object value = 9;

    static String[] cities = {"|1%rB)]}KQ",":1X~Kxl=SE","(uAy{2px]-","bu3?4@R$_e","=z@`U0:vZl","eLhhhK7Tf2","\\Ak>Vh\"]0k","$I#./}G`%2","of-znx|E=o","&+TL`IfQ#u"};

    static String colName = null;

    static int colNumber = -1;

    boolean evaluate(Object value, String colName) {
        if (colName.equalsIgnoreCase(this.colName)) {
            for (String city : cities) {
                if (city.equalsIgnoreCase((String) value)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10348().evaluate(value, colName));
    }
}
