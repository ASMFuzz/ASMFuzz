import java.math.*;

public class MyJVMTest_9460 {

    static char[] bdParam1 = { Character.MAX_VALUE, '0', 'X', 'f', Character.MAX_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, '&', Character.MAX_VALUE, '0' };

    static int bdParam2Param1 = 312;

    static MathContext bdParam2 = new MathContext(bdParam2Param1);

    static BigDecimal bd = new BigDecimal(bdParam1, bdParam2);

    static int mcParam1 = 803;

    static RoundingMode mcParam2 = null;

    static MathContext mc = new MathContext(mcParam1, mcParam2);

    BigDecimal negateThenRound(BigDecimal bd, MathContext mc) {
        return bd.negate().plus(mc);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9460().negateThenRound(bd, mc));
    }
}
