import java.math.*;

public class MyJVMTest_307 {

    static long bdParam1 = -9223372036854775808L;

    static BigDecimal bd = new BigDecimal(bdParam1);

    static int mcParam1 = 966;

    static MathContext mc = new MathContext(mcParam1);

    BigDecimal negateThenRound(BigDecimal bd, MathContext mc) {
        return bd.negate().plus(mc);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_307().negateThenRound(bd, mc));
    }
}
