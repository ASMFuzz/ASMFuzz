public class MyJVMTest_1720 {

    static float[] a = { 0.83607197f, Float.NaN, 0f, Float.MAX_VALUE, 0.2867337f, Float.MAX_VALUE, Float.MIN_VALUE, Float.MAX_VALUE, Float.MAX_VALUE, Float.NaN };

    static float b = Float.MAX_VALUE;

    int test_vi_oppos(float[] a, float b) {
        int limit = a.length - 1;
        for (int i = limit; i >= 0; i -= 1) {
            a[limit - i] = b;
        }
        return limit;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1720().test_vi_oppos(a, b);
    }
}
