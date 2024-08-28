import java.math.*;

public class MyJVMTest_68 {

    static double dividendParam1 = 0d;

    static int dividendParam2Param1 = 873;

    static MathContext dividendParam2 = new MathContext(dividendParam2Param1);

    static BigDecimal dividend = new BigDecimal(dividendParam1, dividendParam2);

    static double divisorParam1 = 0.1642171505704828;

    static int divisorParam2Param1 = 700;

    static MathContext divisorParam2 = new MathContext(divisorParam2Param1);

    static BigDecimal divisor = new BigDecimal(divisorParam1, divisorParam2);

    static BigDecimal[] quotients = { null, null, null, null, null, null, null, null, null, null };

    int divideContextTestPrecs(BigDecimal dividend, BigDecimal divisor, BigDecimal[] quotients) {
        int failures = 0;
        for (int i = 0; i < quotients.length; i++) {
            BigDecimal result = null;
            BigDecimal quotient = quotients[i];
            try {
                result = dividend.divideToIntegralValue(divisor, new MathContext(i, RoundingMode.DOWN));
            } catch (ArithmeticException e) {
                if (quotient != null) {
                    failures++;
                    System.err.println();
                    System.err.println("Unexpected exception:");
                    System.err.println("dividend  = " + dividend + " scale = " + dividend.scale());
                    System.err.println("divisor   = " + divisor + " scale = " + divisor.scale());
                    System.err.println("expected  = " + quotient + " scale = " + quotient.scale());
                }
            }
            if (quotient != null) {
                if (!result.equals(quotient)) {
                    failures++;
                    System.err.println();
                    System.err.println("Unexpected result:");
                    System.err.println("dividend  = " + dividend + " scale = " + dividend.scale());
                    System.err.println("divisor   = " + divisor + " scale = " + divisor.scale());
                    System.err.println("quotient  = " + result + " scale = " + result.scale());
                    System.err.println("expected  = " + quotient + " scale = " + quotient.scale());
                    System.err.println("precision = " + i);
                }
            } else {
                if (result != null) {
                    failures++;
                    System.err.println();
                    System.err.println("Unexpected unexceptional result:");
                    System.err.println("dividend  = " + dividend + " scale = " + dividend.scale());
                    System.err.println("divisor   = " + divisor + " scale = " + divisor.scale());
                    System.err.println("quotient  = " + result + " scale = " + result.scale());
                    System.err.println("precision = " + i);
                }
            }
        }
        return failures;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_68().divideContextTestPrecs(dividend, divisor, quotients));
    }
}
