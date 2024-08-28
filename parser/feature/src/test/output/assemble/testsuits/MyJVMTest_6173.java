public class MyJVMTest_6173 {

    static long x = -3366157155560303547L;

    static long y = 0;

    long safeMethod(long x, long y) {
        long r = x - y;
        if (((x ^ y) & (x ^ r)) < 0) {
            throw new ArithmeticException("integer overflow");
        }
        return r;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6173().safeMethod(x, y));
    }
}
