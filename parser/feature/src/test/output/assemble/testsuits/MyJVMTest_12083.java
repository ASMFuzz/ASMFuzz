public class MyJVMTest_12083 {

    static long[] a = { -9223372036854775808L, 0, -9223372036854775808L, 534155421587221081L, 0, 0, -8033057467155028141L, 9223372036854775807L, 6864908922303376820L, 0 };

    long[] test_ci_oppos(long[] a) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[limit - i] = -123;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12083().test_ci_oppos(a);
    }
}
