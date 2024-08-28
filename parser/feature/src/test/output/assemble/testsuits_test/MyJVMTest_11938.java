public class MyJVMTest_11938 {

    static int[] a = { 5, 5, 3, 402789454, 1, 0, 6, -541655279, 0, 0 };

    static float[] b = { Float.MAX_VALUE, Float.MAX_VALUE, 0.78069544f, Float.MAX_VALUE, 0f, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0f, Float.POSITIVE_INFINITY, Float.NaN };

    int[] test_ci_oppos(int[] a, float[] b) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[limit - i] = -123;
            b[i] = -103.f;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11938().test_ci_oppos(a, b);
    }
}
