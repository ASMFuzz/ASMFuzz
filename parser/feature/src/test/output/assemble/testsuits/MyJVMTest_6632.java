import javax.sql.RowSet;

public class MyJVMTest_6632 {

    static Object value = 1;

    static int columnNumber = 0;

    static int lo = 0;

    static int hi = 0;

    static String colName = null;

    static int colNumber = -1;

    boolean evaluate(Object value, int columnNumber) {
        boolean result = false;
        if (this.colNumber == columnNumber) {
            int columnValue = (Integer) value;
            result = (columnValue >= this.lo) && (columnValue <= this.hi);
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6632().evaluate(value, columnNumber));
    }
}
