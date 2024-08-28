import java.math.*;

public class MyJVMTest_9216 {

    static int dividendParam1 = 142;

    static BigDecimal dividend = new BigDecimal(dividendParam1);

    static int divisorParam1 = 884;

    static int divisorParam2Param1 = 435;

    static MathContext divisorParam2 = new MathContext(divisorParam2Param1);

    static BigDecimal divisor = new BigDecimal(divisorParam1, divisorParam2);

    static int expectedParam1 = 351;

    static BigDecimal expected = new BigDecimal(expectedParam1);

    static int mcParam1 = 688;

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
        System.out.println(new MyJVMTest_9216().divideContextTest(dividend, divisor, expected, mc));
    }
}
