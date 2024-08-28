import javax.sql.RowSet;

public class MyJVMTest_6758 {

    static Object value = 0;

    static String columnName = ";C}4.-2!TP";

    static int lo = 3;

    static int hi = 0;

    static String colName = null;

    static int colNumber = -1;

    boolean evaluate(Object value, String columnName) {
        boolean result = false;
        if (columnName.equalsIgnoreCase(this.colName)) {
            int columnValue = ((Integer) value);
            result = (columnValue >= this.lo) && (columnValue <= this.hi);
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6758().evaluate(value, columnName));
    }
}
