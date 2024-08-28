public class MyJVMTest_5216 {

    static float[] a = { 0.23790139f, Float.MAX_VALUE, Float.MAX_VALUE, Float.MIN_VALUE, Float.POSITIVE_INFINITY, 0.80689967f, 0f, Float.POSITIVE_INFINITY, 0.22752428f, 0f };

    static float b = Float.MAX_VALUE;

    static int SCALE = 2;

    float[] test_vi_scl(float[] a, float b) {
        for (int i = 0; i * SCALE < a.length; i += 1) {
            a[i * SCALE] = b;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5216().test_vi_scl(a, b);
    }
}
