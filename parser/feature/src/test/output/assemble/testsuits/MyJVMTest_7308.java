public class MyJVMTest_7308 {

    static long[] a = { 0, 9223372036854775807L, -8076057197597615157L, 9223372036854775807L, 9223372036854775807L, 0, -9223372036854775808L, 5390660486258373300L, 0, 0 };

    static long b = 0;

    static int SCALE = 2;

    long[] test_vi_scl(long[] a, long b) {
        for (int i = 0; i * SCALE < a.length; i += 1) {
            a[i * SCALE] = b;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7308().test_vi_scl(a, b);
    }
}
