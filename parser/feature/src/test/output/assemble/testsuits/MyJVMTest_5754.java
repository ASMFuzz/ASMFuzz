public class MyJVMTest_5754 {

    static short[] a = { 0, 32767, 32767, 32767, 32767, 32767, 0, 32767, 20439, 0 };

    static int[] b = { 6, 6, 9, 685113584, 1322861231, 2, 2, -1278700047, 0, 2 };

    short[] test_ci_neg(short[] a, int[] b) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = -123;
            b[i] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5754().test_ci_neg(a, b);
    }
}
