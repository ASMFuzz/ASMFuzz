import java.math.*;
import static java.math.BigDecimal.*;

public class MyJVMTest_1849 {

    static char[] bdParam1 = { '0', Character.MIN_VALUE, Character.MIN_VALUE, '0', Character.MAX_VALUE, Character.MAX_VALUE, '0', 'X', '0', 'e' };

    static int bdParam2 = 59;

    static int bdParam3 = 221;

    static BigDecimal bd = new BigDecimal(bdParam1, bdParam2, bdParam3);

    static int expected = 533492479;

    int testPrecision(BigDecimal bd, int expected) {
        int precision = bd.precision();
        if (precision != expected) {
            System.err.printf("For (%s).precision expected %d, got %d%n", bd, expected, precision);
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1849().testPrecision(bd, expected));
    }
}
