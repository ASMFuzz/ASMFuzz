import java.math.*;

public class MyJVMTest_3347 {

    static byte[] dividendParam1Param1 = { 7, 93, 83, 72, -82, 69, 31, 0, 62, 31 };

    static BigInteger dividendParam1 = new BigInteger(dividendParam1Param1);

    static int dividendParam2 = 686;

    static int dividendParam3Param1 = 509;

    static RoundingMode dividendParam3Param2 = null;

    static MathContext dividendParam3 = new MathContext(dividendParam3Param1, dividendParam3Param2);

    static BigDecimal dividend = new BigDecimal(dividendParam1, dividendParam2, dividendParam3);

    static char[] divisorParam1 = { 'h', 'i', Character.MAX_VALUE, '0', '-', '[', '0', Character.MAX_VALUE, Character.MAX_VALUE, Character.MIN_VALUE };

    static BigDecimal divisor = new BigDecimal(divisorParam1);

    static char[] expectedParam1 = { Character.MIN_VALUE, Character.MAX_VALUE, '0', '0', '0', '\\', '.', 'C', '6', Character.MIN_VALUE };

    static int expectedParam2Param1 = 3;

    static RoundingMode expectedParam2Param2 = null;

    static MathContext expectedParam2 = new MathContext(expectedParam2Param1, expectedParam2Param2);

    static BigDecimal expected = new BigDecimal(expectedParam1, expectedParam2);

    static int mcParam1 = 110;

    static MathContext mc = new MathContext(mcParam1);

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
        System.out.println(new MyJVMTest_3347().divideContextTests(dividend, divisor, expected, mc));
    }
}
