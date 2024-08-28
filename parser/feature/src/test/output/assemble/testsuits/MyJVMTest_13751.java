import java.math.*;
import java.util.Random;

public class MyJVMTest_13751 {

    static int bdParam1Param1 = 704;

    static Random bdParam1Param2 = new Random();

    static BigInteger bdParam1 = new BigInteger(bdParam1Param1, bdParam1Param2);

    static int bdParam2 = 358;

    static BigDecimal bd = new BigDecimal(bdParam1, bdParam2);

    static String mcParam1 = ".Ig&tcG&xR";

    static MathContext mc = new MathContext(mcParam1);

    BigDecimal absThenRound(BigDecimal bd, MathContext mc) {
        return bd.abs().plus(mc);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13751().absThenRound(bd, mc));
    }
}
