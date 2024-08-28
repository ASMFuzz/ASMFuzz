import java.math.*;

public class MyJVMTest_2964 {

    static int bdParam1Param1 = 217;

    static byte[] bdParam1Param2 = { -47, -83, -110, 56, 86, 49, 33, 31, 101, -119 };

    static BigInteger bdParam1 = new BigInteger(bdParam1Param1, bdParam1Param2);

    static BigDecimal bd = new BigDecimal(bdParam1);

    static double d = Double.MAX_VALUE;

    double checkDouble(BigDecimal bd, double d) {
        double dbd = bd.doubleValue();
        if (d != dbd) {
            String message = String.format("Bad conversion:" + "got %g (%a)\texpected %g (%a)", d, d, dbd, dbd);
            throw new RuntimeException(message);
        }
        return dbd;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2964().checkDouble(bd, d);
    }
}
