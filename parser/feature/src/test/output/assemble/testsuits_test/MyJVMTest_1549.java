public class MyJVMTest_1549 {

    static int[] a = { 0, 0, 5, 4, -2039789057, 1050073741, 0, 1523862139, 7, 1571459290 };

    static float[] b = { 0f, 0.63195413f, 0.21119744f, Float.MIN_VALUE, 0.81258327f, 0.7838758f, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0f, 0f };

    static int c = 0;

    static float d = Float.NaN;

    int[] test_vi_oppos(int[] a, float[] b, int c, float d) {
        int limit = a.length - 1;
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = c;
            b[limit - i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1549().test_vi_oppos(a, b, c, d);
    }
}
