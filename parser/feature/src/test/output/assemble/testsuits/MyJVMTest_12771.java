import java.math.BigInteger;

public class MyJVMTest_12771 {

    int testByteValueExact() {
        int errors = 0;
        BigInteger[] inRange = { BigInteger.valueOf(Byte.MIN_VALUE), BigInteger.valueOf(0), BigInteger.ONE, BigInteger.TEN, BigInteger.valueOf(Byte.MAX_VALUE) };
        BigInteger[] outOfRange = { BigInteger.valueOf((long) Integer.MIN_VALUE - 1), BigInteger.valueOf((long) Integer.MIN_VALUE), BigInteger.valueOf((int) Short.MIN_VALUE - 1), BigInteger.valueOf((int) Short.MIN_VALUE), BigInteger.valueOf((int) Byte.MIN_VALUE - 1), BigInteger.valueOf((int) Byte.MAX_VALUE + 1), BigInteger.valueOf((int) Short.MAX_VALUE + 1), BigInteger.valueOf((int) Short.MAX_VALUE), BigInteger.valueOf((long) Integer.MAX_VALUE), BigInteger.valueOf((long) Integer.MAX_VALUE + 1) };
        for (BigInteger bi : inRange) {
            if (bi.byteValueExact() != bi.byteValue()) {
                System.err.println("Mismatching byte conversion for " + bi);
                errors++;
            }
        }
        for (BigInteger bi : outOfRange) {
            try {
                int value = bi.byteValueExact();
                System.err.println("Failed to get expected exception on " + bi + " got " + value);
                errors++;
            } catch (ArithmeticException ae) {
                ;
            }
        }
        return errors;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12771().testByteValueExact());
    }
}
