import java.math.*;

public class MyJVMTest_5854 {

    static BigDecimal[][] testCases = { { null, null, null, null, null, null, null, null, null, null }, { null, null, null, null, null, null, null, null, null, null } };

    static int mcParam1 = 116;

    static RoundingMode mcParam2 = null;

    static MathContext mc = new MathContext(mcParam1, mcParam2);

    BigDecimal negateThenRound(BigDecimal bd, MathContext mc) {
        return bd.negate().plus(mc);
    }

    BigDecimal absThenRound(BigDecimal bd, MathContext mc) {
        return bd.abs().plus(mc);
    }

    int negateTest(BigDecimal[][] testCases, MathContext mc) {
        int failures = 0;
        for (BigDecimal[] testCase : testCases) {
            BigDecimal bd = testCase[0];
            BigDecimal neg1 = bd.negate(mc);
            BigDecimal neg2 = negateThenRound(bd, mc);
            BigDecimal expected = testCase[1];
            if (!neg1.equals(expected)) {
                failures++;
                System.err.println("(" + bd + ").negate(" + mc + ") => " + neg1 + " != expected " + expected);
            }
            if (!neg1.equals(neg2)) {
                failures++;
                System.err.println("(" + bd + ").negate(" + mc + ")  => " + neg1 + " != ntr " + neg2);
            }
            BigDecimal abs = bd.abs(mc);
            BigDecimal expectedAbs = absThenRound(bd, mc);
            if (!abs.equals(expectedAbs)) {
                failures++;
                System.err.println("(" + bd + ").abs(" + mc + ")  => " + abs + " != atr " + expectedAbs);
            }
        }
        return failures;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5854().negateTest(testCases, mc));
    }
}
