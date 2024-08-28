import java.math.*;
import java.util.*;

public class MyJVMTest_11731 {

    static MathContext longEnough = new MathContext(50, RoundingMode.UNNECESSARY);

    static BigDecimal[] zeros = new BigDecimal[23];

    int multiplyTests() {
        int failures = 0;
        BigDecimal[] ones = { BigDecimal.valueOf(1, 0), BigDecimal.valueOf(10, 1), BigDecimal.valueOf(1000, 3), BigDecimal.valueOf(100000000, 8) };
        List<BigDecimal> values = new LinkedList<BigDecimal>();
        values.addAll(Arrays.asList(zeros));
        values.addAll(Arrays.asList(ones));
        for (BigDecimal zero1 : zeros) {
            for (BigDecimal value : values) {
                BigDecimal expected = new BigDecimal(BigInteger.ZERO, (int) Math.min(Math.max((long) zero1.scale() + value.scale(), Integer.MIN_VALUE), Integer.MAX_VALUE));
                BigDecimal result;
                if (!(result = zero1.multiply(value)).equals(expected)) {
                    failures++;
                    System.err.println("For classic exact multiply, expected scale of " + expected.scale() + "; got " + result.scale() + ".");
                }
                if (!(result = zero1.multiply(value, MathContext.UNLIMITED)).equals(expected)) {
                    failures++;
                    System.err.println("For UNLIMITED math context multiply," + " expected scale of " + expected.scale() + "; got " + result.scale() + ".");
                }
                if (!(result = zero1.multiply(value, longEnough)).equals(expected)) {
                    failures++;
                    System.err.println("For longEnough math context multiply," + " expected scale of " + expected.scale() + "; got " + result.scale() + ".");
                }
            }
        }
        return failures;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11731().multiplyTests());
    }
}
