import java.math.BigInteger;

public class MyJVMTest_3439 {

    int testIntValueExact() {
        int errors = 0;
        BigInteger[] inRange = { BigInteger.valueOf(Integer.MIN_VALUE), BigInteger.ZERO, BigInteger.ONE, BigInteger.TEN, BigInteger.valueOf(Integer.MAX_VALUE) };
        BigInteger[] outOfRange = { BigInteger.valueOf((long) Integer.MIN_VALUE - 1), BigInteger.valueOf((long) Integer.MAX_VALUE + 1) };
        for (BigInteger bi : inRange) {
            if (bi.intValueExact() != bi.intValue()) {
                System.err.println("Mismatching int conversion for " + bi);
                errors++;
            }
        }
        for (BigInteger bi : outOfRange) {
            try {
                int value = bi.intValueExact();
                System.err.println("Failed to get expected exception on " + bi + " got " + value);
                errors++;
            } catch (ArithmeticException ae) {
                ;
            }
        }
        return errors;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3439().testIntValueExact());
    }
}
