import java.math.*;
import static java.math.BigDecimal.*;

public class MyJVMTest_4753 {

    int properScaleTests() {
        int failures = 0;
        BigDecimal[][] testCases = { { new BigDecimal("1"), new BigDecimal("5"), new BigDecimal("2e-1") }, { new BigDecimal("1"), new BigDecimal("50e-1"), new BigDecimal("2e-1") }, { new BigDecimal("10e-1"), new BigDecimal("5"), new BigDecimal("2e-1") }, { new BigDecimal("1"), new BigDecimal("500e-2"), new BigDecimal("2e-1") }, { new BigDecimal("100e-2"), new BigDecimal("5"), new BigDecimal("20e-2") }, { new BigDecimal("1"), new BigDecimal("32"), new BigDecimal("3125e-5") }, { new BigDecimal("1"), new BigDecimal("64"), new BigDecimal("15625e-6") }, { new BigDecimal("1.0000000"), new BigDecimal("64"), new BigDecimal("156250e-7") } };
        for (BigDecimal[] tc : testCases) {
            BigDecimal quotient;
            if (!(quotient = tc[0].divide(tc[1])).equals(tc[2])) {
                failures++;
                System.err.println("Unexpected quotient from " + tc[0] + " / " + tc[1] + "; expected " + tc[2] + " got " + quotient);
            }
        }
        return failures;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4753().properScaleTests());
    }
}
