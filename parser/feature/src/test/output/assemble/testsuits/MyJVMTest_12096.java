import javax.sql.RowSet;

public class MyJVMTest_12096 {

    static RowSet rs = null;

    static int lo = 1366147120;

    static int hi = -1422825437;

    static String colName = null;

    static int colNumber = -1;

    boolean evaluate(RowSet rs) {
        boolean result = false;
        try {
            int columnValue = -1;
            if (this.colNumber > 0) {
                columnValue = rs.getInt(this.colNumber);
            } else if (this.colName != null) {
                columnValue = rs.getInt(this.colName);
            }
            if ((columnValue >= this.lo) && (columnValue <= this.hi)) {
                result = true;
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
            result = false;
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12096().evaluate(rs));
    }
}
