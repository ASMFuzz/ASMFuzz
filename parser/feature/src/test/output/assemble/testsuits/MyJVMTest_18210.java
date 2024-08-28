import java.math.*;
import java.util.*;

public class MyJVMTest_18210 {

    static MathContext longEnough = new MathContext(50, RoundingMode.UNNECESSARY);

    static BigDecimal[] zeros = new BigDecimal[23];

    int divideTests() {
        int failures = 0;
        BigDecimal[] ones = { BigDecimal.valueOf(1, 0), BigDecimal.valueOf(10, -1), BigDecimal.valueOf(100, -2), BigDecimal.valueOf(1000, -3), BigDecimal.valueOf(1000000, -5) };
        for (BigDecimal one : ones) {
            for (BigDecimal zero : zeros) {
                BigDecimal expected = new BigDecimal(BigInteger.ZERO, (int) Math.min(Math.max((long) zero.scale() - one.scale(), Integer.MIN_VALUE), Integer.MAX_VALUE));
                BigDecimal result;
                if (!(result = zero.divide(one)).equals(expected)) {
                    failures++;
                    System.err.println("For classic exact divide, expected scale of " + expected.scale() + "; got " + result.scale() + ".");
                }
                if (!(result = zero.divide(one, MathContext.UNLIMITED)).equals(expected)) {
                    failures++;
                    System.err.println("For UNLIMITED math context divide," + " expected scale of " + expected.scale() + "; got " + result.scale() + ".");
                }
                if (!(result = zero.divide(one, longEnough)).equals(expected)) {
                    failures++;
                    System.err.println("For longEnough math context divide," + " expected scale of " + expected.scale() + "; got " + result.scale() + ".");
                }
            }
        }
        return failures;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_18210().divideTests());
    }
}
