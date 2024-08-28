public class MyJVMTest_2655 {

    static int[] a = { 0, 0, 5, 1595185184, 0, 0, 7, 0, 4, 0 };

    static float[] b = { Float.MAX_VALUE, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.MAX_VALUE, Float.NEGATIVE_INFINITY, Float.NaN, Float.MIN_VALUE, Float.MIN_VALUE, 0.4303671f, Float.MIN_VALUE };

    int[] test_ci_oppos(int[] a, float[] b) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[limit - i] = -123;
            b[i] = -103.f;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2655().test_ci_oppos(a, b);
    }
}
