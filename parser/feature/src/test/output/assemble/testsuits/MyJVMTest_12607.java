import java.util.*;
import java.math.*;

public class MyJVMTest_12607 {

    static int bdParam1 = 829;

    static int bdParam2Param1 = 994;

    static MathContext bdParam2 = new MathContext(bdParam2Param1);

    static BigDecimal bd = new BigDecimal(bdParam1, bdParam2);

    boolean isPowerOfTen(BigDecimal bd) {
        return BigInteger.ONE.equals(bd.unscaledValue());
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12607().isPowerOfTen(bd));
    }
}
