import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

public class MyJVMTest_6202 {

    static String bdParam1Param1 = "FumNM:49H~";

    static int bdParam1Param2 = 989;

    static BigInteger bdParam1 = new BigInteger(bdParam1Param1, bdParam1Param2);

    static int bdParam2 = 437;

    static int bdParam3Param1 = 915;

    static MathContext bdParam3 = new MathContext(bdParam3Param1);

    static BigDecimal bd = new BigDecimal(bdParam1, bdParam2, bdParam3);

    long simpleLongValue(BigDecimal bd) {
        return bd.toBigInteger().longValue();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6202().simpleLongValue(bd));
    }
}
