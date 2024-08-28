import java.math.*;
import static java.math.BigDecimal.*;

public class MyJVMTest_11075 {

    static char[] bdParam1 = { Character.MIN_VALUE, '?', 'y', Character.MIN_VALUE, Character.MAX_VALUE, '0', 'R', Character.MAX_VALUE, Character.MIN_VALUE, Character.MAX_VALUE };

    static BigDecimal bd = new BigDecimal(bdParam1);

    static int expected = -1353296577;

    int testPrecision(BigDecimal bd, int expected) {
        int precision = bd.precision();
        if (precision != expected) {
            System.err.printf("For (%s).precision expected %d, got %d%n", bd, expected, precision);
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11075().testPrecision(bd, expected));
    }
}
