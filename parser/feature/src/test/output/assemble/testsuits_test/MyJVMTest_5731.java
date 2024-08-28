import java.math.*;

public class MyJVMTest_5731 {

    static char[] bdParam1 = { Character.MIN_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, 's', '0', Character.MAX_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, '7', Character.MAX_VALUE };

    static String bdParam2Param1 = "5z$.UcDqI?";

    static MathContext bdParam2 = new MathContext(bdParam2Param1);

    static BigDecimal bd = new BigDecimal(bdParam1, bdParam2);

    long simpleLongValueExact(BigDecimal bd) {
        return bd.toBigIntegerExact().longValue();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5731().simpleLongValueExact(bd));
    }
}
