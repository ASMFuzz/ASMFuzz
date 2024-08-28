public class MyJVMTest_8228 {

    static int[] a = { 1, 1089613628, 0, 0, 0, 5, -1220455125, 1605336174, 0, 5 };

    static float[] b = { Float.POSITIVE_INFINITY, Float.MAX_VALUE, 0f, Float.MAX_VALUE, Float.NaN, Float.POSITIVE_INFINITY, Float.MIN_VALUE, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY };

    int[] test_ci(int[] a, float[] b) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = -123;
            b[i] = -103.f;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8228().test_ci(a, b);
    }
}
