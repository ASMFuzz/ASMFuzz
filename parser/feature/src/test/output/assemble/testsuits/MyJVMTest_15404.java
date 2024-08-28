public class MyJVMTest_15404 {

    static long[] a = { 0, 0, 9223372036854775807L, 1332911198058468733L, 9223372036854775807L, 9223372036854775807L, 9223372036854775807L, 0, 9223372036854775807L, 0 };

    static int OFFSET = 3;

    long[] test_ci_off(long[] a) {
        for (int i = 0; i < a.length - OFFSET; i += 1) {
            a[i + OFFSET] = -123;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15404().test_ci_off(a);
    }
}
