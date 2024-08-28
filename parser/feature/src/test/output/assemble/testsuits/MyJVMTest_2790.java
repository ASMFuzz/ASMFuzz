public class MyJVMTest_2790 {

    static long[] a = { -3523252607730061374L, 0, -4929567846468221263L, 0, 0, 0, -9223372036854775808L, -9223372036854775808L, -901807438615674803L, 4599475922037355209L };

    long[] test_ci_oppos(long[] a) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[limit - i] = -123;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2790().test_ci_oppos(a);
    }
}
