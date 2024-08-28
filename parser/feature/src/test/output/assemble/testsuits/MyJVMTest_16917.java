public class MyJVMTest_16917 {

    static int[] a = { 5, 0, 0, 0, 0, 4, 6, 0, 3, 0 };

    static long[] b = { 0, 0, -9223372036854775808L, 0, 0, 0, 0, 0, 90512787440938901L, 9223372036854775807L };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    int[] test_ci_unaln(int[] a, long[] b) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i + UNALIGN_OFF] = -123;
            b[i] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16917().test_ci_unaln(a, b);
    }
}
