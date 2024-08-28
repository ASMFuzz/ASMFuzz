public class MyJVMTest_6797 {

    static int[] a = { 0, 6, 1, 0, 0, 7, 4, 1788219640, 9, 0 };

    static float[] b = { 0.458318f, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.MAX_VALUE, Float.MAX_VALUE, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY };

    static int c = 0;

    static float d = 0f;

    int[] test_vi_neg(int[] a, float[] b, int c, float d) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = c;
            b[i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6797().test_vi_neg(a, b, c, d);
    }
}
