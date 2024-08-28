import java.math.*;

public class MyJVMTest_12267 {

    static char[] bdParam1 = { Character.MIN_VALUE, '0', Character.MAX_VALUE, '1', Character.MAX_VALUE, '0', Character.MIN_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, '0' };

    static BigDecimal bd = new BigDecimal(bdParam1);

    static double d = Double.POSITIVE_INFINITY;

    double checkDouble(BigDecimal bd, double d) {
        double dbd = bd.doubleValue();
        if (d != dbd) {
            String message = String.format("Bad conversion:" + "got %g (%a)\texpected %g (%a)", d, d, dbd, dbd);
            throw new RuntimeException(message);
        }
        return dbd;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12267().checkDouble(bd, d);
    }
}
