import java.util.*;
import java.math.*;

public class MyJVMTest_3283 {

    static String bdParam1Param1 = "d//F \"/aj{";

    static int bdParam1Param2 = 865;

    static BigInteger bdParam1 = new BigInteger(bdParam1Param1, bdParam1Param2);

    static BigDecimal bd = new BigDecimal(bdParam1);

    boolean isPowerOfTen(BigDecimal bd) {
        return BigInteger.ONE.equals(bd.unscaledValue());
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3283().isPowerOfTen(bd));
    }
}
