import java.math.*;

public class MyJVMTest_4376 {

    static byte[] bdParam1Param1 = { -103, -59, 35, -31, 39, -32, -116, 21, 68, -76 };

    static BigInteger bdParam1 = new BigInteger(bdParam1Param1);

    static int bdParam2 = 360;

    static int bdParam3Param1 = 3;

    static RoundingMode bdParam3Param2 = null;

    static MathContext bdParam3 = new MathContext(bdParam3Param1, bdParam3Param2);

    static BigDecimal bd = new BigDecimal(bdParam1, bdParam2, bdParam3);

    static String mcParam1 = "9;KwzB>pE9";

    static MathContext mc = new MathContext(mcParam1);

    BigDecimal absThenRound(BigDecimal bd, MathContext mc) {
        return bd.abs().plus(mc);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4376().absThenRound(bd, mc));
    }
}
