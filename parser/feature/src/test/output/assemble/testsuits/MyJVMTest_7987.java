public class MyJVMTest_7987 {

    static int[] a = { 0, 1, 9, 0, 7, 6, 0, 1327459583, -457376018, 6 };

    static float[] b = { Float.MIN_VALUE, 0.51071167f, Float.MIN_VALUE, Float.MAX_VALUE, Float.NaN, Float.NEGATIVE_INFINITY, Float.MIN_VALUE, Float.MIN_VALUE, Float.NEGATIVE_INFINITY, 0.99115866f };

    static int c = 0;

    static float d = Float.NaN;

    static int ALIGN_OFF = 8;

    int[] test_vi_aln(int[] a, float[] b, int c, float d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i] = c;
            b[i + ALIGN_OFF] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7987().test_vi_aln(a, b, c, d);
    }
}
