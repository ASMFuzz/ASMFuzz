public class MyJVMTest_10943 {

    static float[] a = { Float.MAX_VALUE, Float.MAX_VALUE, Float.MAX_VALUE, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, 0f, Float.NEGATIVE_INFINITY, 0.07945609f, 0.27886057f, Float.MAX_VALUE };

    static float b = Float.NaN;

    int test_vi_oppos(float[] a, float b) {
        int limit = a.length - 1;
        for (int i = limit; i >= 0; i -= 1) {
            a[limit - i] = b;
        }
        return limit;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10943().test_vi_oppos(a, b);
    }
}
