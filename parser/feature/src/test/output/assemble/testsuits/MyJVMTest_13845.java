public class MyJVMTest_13845 {

    static long x = 9223372036854775807L;

    static long y = 3898418484705377124L;

    long safeMethod(long x, long y) {
        long r = x + y;
        if (((x ^ r) & (y ^ r)) < 0) {
            throw new ArithmeticException("integer overflow");
        }
        return r;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13845().safeMethod(x, y));
    }
}
