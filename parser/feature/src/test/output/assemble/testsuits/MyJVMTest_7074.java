import java.math.*;
import java.util.*;

public class MyJVMTest_7074 {

    static MathContext longEnough = new MathContext(50, RoundingMode.UNNECESSARY);

    static BigDecimal[] zeros = new BigDecimal[23];

    static BigDecimal element = BigDecimal.valueOf(100, -2);

    static MathContext[] contexts = { new MathContext(0, RoundingMode.UNNECESSARY), new MathContext(100, RoundingMode.UNNECESSARY), new MathContext(5, RoundingMode.UNNECESSARY), new MathContext(4, RoundingMode.UNNECESSARY), new MathContext(3, RoundingMode.UNNECESSARY), new MathContext(2, RoundingMode.UNNECESSARY), new MathContext(1, RoundingMode.UNNECESSARY) };

    int addTests() {
        int failures = 0;
        for (BigDecimal zero1 : zeros) {
            for (BigDecimal zero2 : zeros) {
                BigDecimal expected = new BigDecimal(BigInteger.ZERO, Math.max(zero1.scale(), zero2.scale()));
                BigDecimal result;
                if (!(result = zero1.add(zero2)).equals(expected)) {
                    failures++;
                    System.err.println("For classic exact add, expected scale of " + expected.scale() + "; got " + result.scale() + ".");
                }
                if (!(result = zero1.add(zero2, MathContext.UNLIMITED)).equals(expected)) {
                    failures++;
                    System.err.println("For UNLIMITED math context add," + " expected scale of " + expected.scale() + "; got " + result.scale() + ".");
                }
                if (!(result = zero1.add(zero2, longEnough)).equals(expected)) {
                    failures++;
                    System.err.println("For longEnough math context add," + " expected scale of " + expected.scale() + "; got " + result.scale() + ".");
                }
            }
        }
        for (MathContext mc : contexts) {
            for (BigDecimal zero : zeros) {
                if (Math.abs((long) zero.scale()) < 100) {
                    int preferredScale = Math.max(zero.scale(), element.scale());
                    if (mc.getPrecision() != 0) {
                        if (preferredScale < -4)
                            preferredScale = -4;
                        else if (preferredScale > -(5 - mc.getPrecision())) {
                            preferredScale = -(5 - mc.getPrecision());
                        }
                    }
                    BigDecimal result = element.add(zero, mc);
                    if (result.scale() != preferredScale || result.compareTo(element) != 0) {
                        failures++;
                        System.err.println("Expected scale  " + preferredScale + " result scale was " + result.scale() + " ; value was " + result);
                    }
                    result = zero.add(element, mc);
                    if (result.scale() != preferredScale || result.compareTo(element) != 0) {
                        failures++;
                        System.err.println("Expected scale  " + preferredScale + " result scale was " + result.scale() + " ; value was " + result);
                    }
                    result = element.negate().add(zero, mc);
                    if (result.scale() != preferredScale || result.compareTo(element.negate()) != 0) {
                        failures++;
                        System.err.println("Expected scale  " + preferredScale + " result scale was " + result.scale() + " ; value was " + result);
                    }
                    result = zero.add(element.negate(), mc);
                    if (result.scale() != preferredScale || result.compareTo(element.negate()) != 0) {
                        failures++;
                        System.err.println("Expected scale  " + preferredScale + " result scale was " + result.scale() + " ; value was " + result);
                    }
                }
            }
        }
        return failures;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7074().addTests());
    }
}
