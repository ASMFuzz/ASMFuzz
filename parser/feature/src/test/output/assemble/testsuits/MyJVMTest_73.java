import java.math.*;

public class MyJVMTest_73 {

    static char[] dividendParam1 = { Character.MIN_VALUE, '0', 'N', '0', Character.MIN_VALUE, 'U', Character.MIN_VALUE, '0', '0', Character.MAX_VALUE };

    static int dividendParam2Param1 = 629;

    static RoundingMode dividendParam2Param2 = null;

    static MathContext dividendParam2 = new MathContext(dividendParam2Param1, dividendParam2Param2);

    static BigDecimal dividend = new BigDecimal(dividendParam1, dividendParam2);

    static double divisorParam1 = Double.NEGATIVE_INFINITY;

    static BigDecimal divisor = new BigDecimal(divisorParam1);

    static double expectedParam1 = Double.POSITIVE_INFINITY;

    static BigDecimal expected = new BigDecimal(expectedParam1);

    static int mcParam1 = 64;

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

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_73().divideContextTest(dividend, divisor, expected, mc));
    }
}
