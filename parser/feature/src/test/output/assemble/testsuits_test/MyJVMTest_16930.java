public class MyJVMTest_16930 {

    static int[] a = { 1923951628, 8, -2122550474, 0, 7, 0, 7, -344924143, 0, 0 };

    static int[] b = { 9, 1719785899, 2, 7, 1494417000, 1, 7, 538886966, 7, 3 };

    static float[] c = { Float.POSITIVE_INFINITY, Float.MIN_VALUE, Float.NEGATIVE_INFINITY, Float.MAX_VALUE, 0.7911467f, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, Float.MAX_VALUE, Float.POSITIVE_INFINITY, Float.NaN };

    static float[] d = { Float.MIN_VALUE, Float.NEGATIVE_INFINITY, 0f, Float.MAX_VALUE, 0f, Float.MAX_VALUE, Float.NEGATIVE_INFINITY, 0.106271744f, Float.NaN, 0.86763626f };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    int[] test_cp_unalnsrc(int[] a, int[] b, float[] c, float[] d) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i] = b[i + UNALIGN_OFF];
            c[i] = d[i + UNALIGN_OFF];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16930().test_cp_unalnsrc(a, b, c, d);
    }
}
