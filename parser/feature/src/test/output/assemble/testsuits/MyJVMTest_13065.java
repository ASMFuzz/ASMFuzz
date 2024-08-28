import java.sql.SQLException;

public class MyJVMTest_13065 {

    static Object value = 0;

    static String[] cities = {"bc.U`@w$&a","8k)/fYx>nf","PE;07wo2D)","3]A`_z\\NZu","7)[Gp,M|xX","@|INZsam5Q","{Gcm3!%pV2",";'h0Uq[?Wt","k}+T6)&6%8","OW3|'_McXK"};

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
        System.out.println(new MyJVMTest_13065().evaluate(value, colNumber));
    }
}
