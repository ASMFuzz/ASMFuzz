import java.math.*;

public class MyJVMTest_9210 {

    static char[] dividendParam1 = { Character.MAX_VALUE, '0', '0', Character.MAX_VALUE, '0', '[', Character.MIN_VALUE, '>', Character.MAX_VALUE, Character.MIN_VALUE };

    static BigDecimal dividend = new BigDecimal(dividendParam1);

    static long divisorParam1 = 9223372036854775807L;

    static BigDecimal divisor = new BigDecimal(divisorParam1);

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
        System.out.println(new MyJVMTest_9210().divideContextTestPrecs(dividend, divisor, quotients));
    }
}
