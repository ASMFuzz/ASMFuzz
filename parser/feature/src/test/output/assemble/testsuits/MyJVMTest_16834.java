public class MyJVMTest_16834 {

    static long[] a = { 9223372036854775807L, 9223372036854775807L, 6656101066685106850L, 9223372036854775807L, 9223372036854775807L, 9223372036854775807L, -3383281766694632150L, 9223372036854775807L, 9223372036854775807L, 9223372036854775807L };

    static long b = -2635515890465500390L;

    static int SCALE = 2;

    long[] test_vi_scl(long[] a, long b) {
        for (int i = 0; i * SCALE < a.length; i += 1) {
            a[i * SCALE] = b;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16834().test_vi_scl(a, b);
    }
}
