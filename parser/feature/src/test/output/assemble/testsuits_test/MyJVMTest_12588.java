import java.math.BigInteger;

public class MyJVMTest_12588 {

    int testLongValueExact() {
        int errors = 0;
        BigInteger[] inRange = { BigInteger.valueOf(Long.MIN_VALUE), BigInteger.ZERO, BigInteger.valueOf(Long.MAX_VALUE) };
        BigInteger[] outOfRange = { BigInteger.valueOf(Long.MIN_VALUE).subtract(BigInteger.ONE), BigInteger.valueOf(Long.MAX_VALUE).add(BigInteger.ONE) };
        for (BigInteger bi : inRange) {
            if (bi.longValueExact() != bi.longValue()) {
                System.err.println("Mismatching int conversion for " + bi);
                errors++;
            }
        }
        for (BigInteger bi : outOfRange) {
            try {
                long value = bi.longValueExact();
                System.err.println("Failed to get expected exception on " + bi + " got " + value);
                errors++;
            } catch (ArithmeticException ae) {
                ;
            }
        }
        return errors;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12588().testLongValueExact());
    }
}
