import java.math.BigInteger;

public class MyJVMTest_9761 {

    int testShortValueExact() {
        int errors = 0;
        BigInteger[] inRange = { BigInteger.valueOf(Short.MIN_VALUE), BigInteger.ZERO, BigInteger.ONE, BigInteger.TEN, BigInteger.valueOf(Short.MAX_VALUE) };
        BigInteger[] outOfRange = { BigInteger.valueOf((long) Integer.MIN_VALUE - 1), BigInteger.valueOf((long) Integer.MIN_VALUE), BigInteger.valueOf((int) Short.MIN_VALUE - 1), BigInteger.valueOf((int) Short.MAX_VALUE + 1), BigInteger.valueOf((long) Integer.MAX_VALUE), BigInteger.valueOf((long) Integer.MAX_VALUE + 1) };
        for (BigInteger bi : inRange) {
            if (bi.shortValueExact() != bi.shortValue()) {
                System.err.println("Mismatching short  conversion for " + bi);
                errors++;
            }
        }
        for (BigInteger bi : outOfRange) {
            try {
                int value = bi.shortValueExact();
                System.err.println("Failed to get expected exception on " + bi + " got " + value);
                errors++;
            } catch (ArithmeticException ae) {
                ;
            }
        }
        return errors;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9761().testShortValueExact());
    }
}
