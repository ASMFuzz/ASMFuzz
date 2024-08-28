import java.sql.SQLException;

public class MyJVMTest_3727 {

    static Object value = 4;

    static String[] cities = {"BMD{\"2y8hY","DNAD+VJVJx","+6hvCr\\Lq6","~(9=-\\uw8=","sgf_5|p$5q","_t5$aI_I~~","LZ-R</A\\?,","?E{Rw$ VvQ","#HT?t\"2O2S","G@[xwVKjlr"};

    static String colName = null;

    static int colNumber = -1;

    boolean evaluate(Object value, int colNumber) {
        if (colNumber == this.colNumber) {
            for (String city : this.cities) {
                if (city.equalsIgnoreCase((String) value)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3727().evaluate(value, colNumber));
    }
}
