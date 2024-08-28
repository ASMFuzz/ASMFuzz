import java.math.*;

public class MyJVMTest_12674 {

    static int dividendParam1 = 538;

    static BigDecimal dividend = new BigDecimal(dividendParam1);

    static long divisorParam1 = 9223372036854775807L;

    static BigDecimal divisor = new BigDecimal(divisorParam1);

    static char[] expectedParam1 = { 'd', '0', '0', Character.MAX_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, '>', 'r', Character.MAX_VALUE, Character.MAX_VALUE };

    static BigDecimal expected = new BigDecimal(expectedParam1);

    static int mcParam1 = 447;

    static RoundingMode mcParam2 = null;

    static MathContext mc = new MathContext(mcParam1, mcParam2);

    int divideContextTest(BigDecimal dividend, BigDecimal divisor, BigDecimal expected, MathContext mc) {
        int failures = 0;
        BigDecimal result = null;
        try {
            result = dividend.divideToIntegralValue(divisor, mc);
        } catch (ArithmeticException e) {
            if (expected != null) {
                failures++;
                System.err.println();
                System.err.println("Unexpected exception:");
                System.err.println("dividend  = " + dividend + " scale = " + dividend.scale());
                System.err.println("divisor   = " + divisor + " scale = " + divisor.scale());
                System.err.println("expected  = " + expected + " scale = " + expected.scale());
                System.err.println("MathContext  = " + mc);
            }
        }
        if (expected != null) {
            if (!result.equals(expected)) {
                failures++;
                System.err.println();
                System.err.println("Unexpected result:");
                System.err.println("dividend  = " + dividend + " scale = " + dividend.scale());
                System.err.println("divisor   = " + divisor + " scale = " + divisor.scale());
                System.err.println("expected  = " + expected + " scale = " + expected.scale());
                System.err.println("result    = " + result + " scale = " + result.scale());
                System.err.println("MathContext  = " + mc);
            }
        } else {
            if (result != null) {
                failures++;
                System.err.println();
                System.err.println("Unexpected unexceptional result:");
                System.err.println("dividend  = " + dividend + " scale = " + dividend.scale());
                System.err.println("divisor   = " + divisor + " scale = " + divisor.scale());
                System.err.println("quotient  = " + result + " scale = " + result.scale());
                System.err.println("MathConext = " + mc);
            }
        }
        return failures;
    }

    int divideContextTests(BigDecimal dividend, BigDecimal divisor, BigDecimal expected, MathContext mc) {
        int failures = 0;
        failures += divideContextTest(dividend, divisor, expected, mc);
        failures += divideContextTest(dividend.negate(), divisor.negate(), expected, mc);
        if (expected != null) {
            failures += divideContextTest(dividend.negate(), divisor, expected.negate(), mc);
            failures += divideContextTest(dividend, divisor.negate(), expected.negate(), mc);
        }
        return failures;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12674().divideContextTests(dividend, divisor, expected, mc));
    }
}
