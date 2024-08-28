import java.math.*;

public class MyJVMTest_8544 {

    int dividetoIntegralValueTests() {
        int failures = 0;
        BigDecimal[][] moreTestCases = { { new BigDecimal("11003"), new BigDecimal("10"), new BigDecimal("1100") }, { new BigDecimal("11003"), new BigDecimal("1e1"), new BigDecimal("1100.0") }, { new BigDecimal("1e9"), new BigDecimal("1"), new BigDecimal("1e9") }, { new BigDecimal("1e9"), new BigDecimal("1.00"), new BigDecimal("1e9") }, { new BigDecimal("1e9"), new BigDecimal("0.1"), new BigDecimal("1e10") }, { new BigDecimal("10e8"), new BigDecimal("0.1"), new BigDecimal("10e9") }, { new BigDecimal("400e1"), new BigDecimal("5"), new BigDecimal("80e1") }, { new BigDecimal("400e1"), new BigDecimal("4.999999999"), new BigDecimal("8e2") }, { new BigDecimal("40e2"), new BigDecimal("5"), new BigDecimal("8e2") }, { BigDecimal.valueOf(1, Integer.MIN_VALUE), BigDecimal.valueOf(1, -(Integer.MAX_VALUE & 0x7fffff00)), BigDecimal.valueOf(1, -256) } };
        for (BigDecimal[] testCase : moreTestCases) {
            BigDecimal quotient;
            if (!(quotient = testCase[0].divideToIntegralValue(testCase[1])).equals(testCase[2])) {
                failures++;
                System.err.println();
                System.err.println("dividend  = " + testCase[0] + " scale = " + testCase[0].scale());
                System.err.println("divisor   = " + testCase[1] + " scale = " + testCase[1].scale());
                System.err.println("quotient  = " + quotient + " scale = " + quotient.scale());
                System.err.println("expected  = " + testCase[2] + " scale = " + testCase[2].scale());
            }
        }
        return failures;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8544().dividetoIntegralValueTests());
    }
}
