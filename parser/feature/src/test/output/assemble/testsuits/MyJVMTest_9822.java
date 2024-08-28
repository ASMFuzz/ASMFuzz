public class MyJVMTest_9822 {

    static long x = 9223372036854775807L;

    static long y = 0;

    long safeMethod(long x, long y) {
        long r = x * y;
        long ax = Math.abs(x);
        long ay = Math.abs(y);
        if (((ax | ay) >>> 31 != 0)) {
            if (((y != 0) && (r / y != x)) || (x == Long.MIN_VALUE && y == -1)) {
                throw new ArithmeticException("long overflow");
            }
        }
        return r;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9822().safeMethod(x, y));
    }
}
