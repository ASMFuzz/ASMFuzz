import java.math.*;

public class MyJVMTest_15172 {

    static char[] bdParam1 = { Character.MIN_VALUE, '0', 'j', Character.MAX_VALUE, '0', '0', Character.MAX_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, Character.MIN_VALUE };

    static int bdParam2Param1 = 235;

    static MathContext bdParam2 = new MathContext(bdParam2Param1);

    static BigDecimal bd = new BigDecimal(bdParam1, bdParam2);

    long simpleLongValueExact(BigDecimal bd) {
        return bd.toBigIntegerExact().longValue();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15172().simpleLongValueExact(bd));
    }
}
