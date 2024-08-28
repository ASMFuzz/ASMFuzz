import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

public class MyJVMTest_15675 {

    static byte[] bdParam1Param1 = { -118, -25, -32, 85, 11, 106, 9, 95, -1, -4 };

    static BigInteger bdParam1 = new BigInteger(bdParam1Param1);

    static int bdParam2 = 494;

    static int bdParam3Param1 = 336;

    static RoundingMode bdParam3Param2 = null;

    static MathContext bdParam3 = new MathContext(bdParam3Param1, bdParam3Param2);

    static BigDecimal bd = new BigDecimal(bdParam1, bdParam2, bdParam3);

    long simpleLongValue(BigDecimal bd) {
        return bd.toBigInteger().longValue();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15675().simpleLongValue(bd));
    }
}
