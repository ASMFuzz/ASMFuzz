public class MyJVMTest_10399 {

    static long x = -9223372036854775808L;

    static long DIVISOR = -2210340788125383362L;

    long fcomp(long x) {
        return x % DIVISOR;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10399().fcomp(x));
    }
}
