import java.sql.SQLException;

public class MyJVMTest_1152 {

    static Object value = 3;

    static String[] cities = {"8X[S&i>;0!","F5*{l!5TX}","LWLGn<*bHP","\"-.#M,zuNL","gsk;m{9]<l","G]uUupeyp%","vC?61)=8h#","nqhv;'rxb'","45jDjE\"to'","6o.cnY7eX "};

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
        System.out.println(new MyJVMTest_1152().evaluate(value, colName));
    }
}
