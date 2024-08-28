import java.math.*;
import static java.math.BigDecimal.*;

public class MyJVMTest_3554 {

    int trailingZeroTests() {
        int failures = 0;
        MathContext mc = new MathContext(3, RoundingMode.FLOOR);
        BigDecimal[][] testCases = { { new BigDecimal("19"), new BigDecimal("100"), new BigDecimal("0.19") }, { new BigDecimal("21"), new BigDecimal("110"), new BigDecimal("0.190") } };
        for (BigDecimal[] tc : testCases) {
            BigDecimal quotient;
            if (!(quotient = tc[0].divide(tc[1], mc)).equals(tc[2])) {
                failures++;
                System.err.println("Unexpected quotient from " + tc[0] + " / " + tc[1] + "; expected " + tc[2] + " got " + quotient);
            }
        }
        return failures;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3554().trailingZeroTests());
    }
}
