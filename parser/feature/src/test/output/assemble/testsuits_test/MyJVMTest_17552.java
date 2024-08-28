public class MyJVMTest_17552 {

    static int[] a = { 5, 0, 0, 2, -1629227956, 0, 3, -1043421620, 0, 9 };

    static float[] b = { Float.MAX_VALUE, 0f, Float.MAX_VALUE, 0.5011492f, Float.MIN_VALUE, 0f, Float.NaN, Float.POSITIVE_INFINITY, Float.MAX_VALUE, Float.POSITIVE_INFINITY };

    static int c = 1172655940;

    static float d = Float.MIN_VALUE;

    static int ALIGN_OFF = 8;

    int[] test_vi_aln(int[] a, float[] b, int c, float d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i] = c;
            b[i + ALIGN_OFF] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17552().test_vi_aln(a, b, c, d);
    }
}
