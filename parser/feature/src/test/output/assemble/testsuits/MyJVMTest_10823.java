public class MyJVMTest_10823 {

    static short[] a = { 0, 0, -32768, 0, 0, -32768, -8153, -32768, -12245, 0 };

    static float[] b = { Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, 0.36585635f, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, 0.30417782f, Float.POSITIVE_INFINITY };

    short[] test_ci_oppos(short[] a, float[] b) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[limit - i] = -123;
            b[i] = -103.f;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10823().test_ci_oppos(a, b);
    }
}
