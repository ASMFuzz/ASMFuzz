import javax.sql.RowSet;

public class MyJVMTest_16255 {

    static Object value = 0;

    static String columnName = "]:#c\\<Z-s3";

    static int lo = 2;

    static int hi = 4;

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
        System.out.println(new MyJVMTest_16255().evaluate(value, columnName));
    }
}
