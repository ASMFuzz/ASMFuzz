public class MyJVMTest_6573 {

    static int[] a = { 658964076, 6, 0, 8, 1104097180, 7, 0, -654884390, 401031300, 0 };

    static int[] b = { -823558205, 8, 0, 0, 0, 6, 8, 9, 1, 0 };

    static float[] c = { Float.MIN_VALUE, 0f, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.64799744f, 0.30148393f, 0f, 0f, Float.MAX_VALUE, Float.MIN_VALUE };

    static float[] d = { Float.MIN_VALUE, 0f, Float.MIN_VALUE, Float.MIN_VALUE, Float.POSITIVE_INFINITY, 0f, 0f, Float.NaN, 0.055885077f, 0f };

    int[] test_cp_oppos(int[] a, int[] b, float[] c, float[] d) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b[limit - i];
            c[limit - i] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6573().test_cp_oppos(a, b, c, d);
    }
}
