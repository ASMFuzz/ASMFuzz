public class MyJVMTest_17014 {

    static long MAX_UNSIGNED_INT = Integer.toUnsignedLong(0xffff_ffff);

    int testDivideAndRemainder() {
        int errors = 0;
        long[] inRange = { 0L, 1L, 2L, 2147483646L, 2147483647L, 2147483648L, MAX_UNSIGNED_INT - 1L, MAX_UNSIGNED_INT };
        for (long dividend : inRange) {
            for (long divisor : inRange) {
                int quotient;
                long longQuotient;
                int remainder;
                long longRemainder;
                if (divisor == 0) {
                    try {
                        quotient = Integer.divideUnsigned((int) dividend, (int) divisor);
                        errors++;
                    } catch (ArithmeticException ea) {
                        ;
                    }
                    try {
                        remainder = Integer.remainderUnsigned((int) dividend, (int) divisor);
                        errors++;
                    } catch (ArithmeticException ea) {
                        ;
                    }
                } else {
                    quotient = Integer.divideUnsigned((int) dividend, (int) divisor);
                    longQuotient = dividend / divisor;
                    if (quotient != (int) longQuotient) {
                        errors++;
                        System.err.printf("Unexpected unsigned divide result %s on %s/%s%n", Integer.toUnsignedString(quotient), Integer.toUnsignedString((int) dividend), Integer.toUnsignedString((int) divisor));
                    }
                    remainder = Integer.remainderUnsigned((int) dividend, (int) divisor);
                    longRemainder = dividend % divisor;
                    if (remainder != (int) longRemainder) {
                        errors++;
                        System.err.printf("Unexpected unsigned remainder result %s on %s%%%s%n", Integer.toUnsignedString(remainder), Integer.toUnsignedString((int) dividend), Integer.toUnsignedString((int) divisor));
                    }
                }
            }
        }
        return errors;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17014().testDivideAndRemainder());
    }
}
