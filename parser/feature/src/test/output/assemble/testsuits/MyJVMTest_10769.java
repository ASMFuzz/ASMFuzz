public class MyJVMTest_10769 {

    static int[] a = { 6, 0, -689667008, -310967166, 7, 8, 8, 0, 2, 0 };

    static float[] b = { Float.MIN_VALUE, Float.MAX_VALUE, Float.NEGATIVE_INFINITY, 0.74574363f, Float.MIN_VALUE, Float.POSITIVE_INFINITY, 0.8270903f, Float.NaN, 0f, Float.NaN };

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
        new MyJVMTest_10769().test_vi_oppos(a, b, c, d);
    }
}
