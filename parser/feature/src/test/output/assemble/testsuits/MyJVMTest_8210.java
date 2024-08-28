import java.math.*;

public class MyJVMTest_8210 {

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

    int dividetoIntegralValueRoundedTests() {
        int failures = 0;
        BigDecimal dividend = new BigDecimal("11003");
        BigDecimal divisor = new BigDecimal("10");
        BigDecimal[] quotients = { new BigDecimal("1100"), null, new BigDecimal("11e2"), new BigDecimal("110e1"), new BigDecimal("1100") };
        failures += divideContextTestPrecs(dividend, divisor, quotients);
        dividend = new BigDecimal("11003");
        divisor = new BigDecimal("1e1");
        BigDecimal[] quotients2 = { new BigDecimal("1100.0"), null, new BigDecimal("11e2"), new BigDecimal("110e1"), new BigDecimal("1100"), new BigDecimal("1100.0") };
        failures += divideContextTestPrecs(dividend, divisor, quotients2);
        dividend = new BigDecimal("1230000");
        divisor = new BigDecimal("100");
        BigDecimal[] quotients3 = { new BigDecimal("12300"), null, null, new BigDecimal("123e2"), new BigDecimal("1230e1"), new BigDecimal("12300") };
        failures += divideContextTestPrecs(dividend, divisor, quotients3);
        dividend = new BigDecimal("33");
        divisor = new BigDecimal("3");
        BigDecimal[] quotients4 = { new BigDecimal("11"), null, new BigDecimal("11"), new BigDecimal("11") };
        failures += divideContextTestPrecs(dividend, divisor, quotients4);
        dividend = new BigDecimal("34");
        divisor = new BigDecimal("3");
        BigDecimal[] quotients5 = { new BigDecimal("11"), null, new BigDecimal("11"), new BigDecimal("11") };
        failures += divideContextTestPrecs(dividend, divisor, quotients5);
        return failures;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8210().dividetoIntegralValueRoundedTests());
    }
}
