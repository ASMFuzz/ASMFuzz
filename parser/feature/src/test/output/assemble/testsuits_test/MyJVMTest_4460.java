public class MyJVMTest_4460 {

    static long x = 2145378497226553519L;

    static long y = 9223372036854775807L;

    long safeMethod(long x, long y) {
        long r = x + y;
        if (((x ^ r) & (y ^ r)) < 0) {
            throw new ArithmeticException("integer overflow");
        }
        return r;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4460().safeMethod(x, y));
    }
}
