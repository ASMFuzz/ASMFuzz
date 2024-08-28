public class MyJVMTest_15645 {

    static long x = 9223372036854775807L;

    static long y = 0;

    long safeMethod(long x, long y) {
        long r = x - y;
        if (((x ^ y) & (x ^ r)) < 0) {
            throw new ArithmeticException("integer overflow");
        }
        return r;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15645().safeMethod(x, y));
    }
}
