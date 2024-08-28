public class MyJVMTest_12416 {

    static short[] a = { -32768, 4467, 0, 32767, -32768, -32768, 32767, -8246, 32767, -10972 };

    static int[] b = { 0, 0, 5, -874009862, 7, 3, 2026717214, 9, 1688265930, -702542428 };

    static int ALIGN_OFF = 8;

    short[] test_ci_aln(short[] a, int[] b) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i + ALIGN_OFF] = -123;
            b[i] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12416().test_ci_aln(a, b);
    }
}
