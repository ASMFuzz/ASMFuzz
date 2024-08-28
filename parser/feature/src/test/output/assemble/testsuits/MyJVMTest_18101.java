public class MyJVMTest_18101 {

    static long[] a = { 9223372036854775807L, 0, 9223372036854775807L, 707817723117443520L, 9223372036854775807L, 9223372036854775807L, 9223372036854775807L, 2186187532295061632L, 9223372036854775807L, -9223372036854775808L };

    static int SCALE = 2;

    long[] test_ci_scl(long[] a) {
        for (int i = 0; i * SCALE < a.length; i += 1) {
            a[i * SCALE] = -123;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_18101().test_ci_scl(a);
    }
}
