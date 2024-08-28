public class MyJVMTest_12531 {

    static short[] a = { -32768, -32768, 32767, 0, 0, 32767, -2063, 32767, -32768, 32767 };

    static float[] b = { Float.POSITIVE_INFINITY, 0.5751481f, Float.MIN_VALUE, 0.8056459f, Float.MAX_VALUE, Float.POSITIVE_INFINITY, Float.MIN_VALUE, 0.4800753f, 0.037216842f, 0.46148956f };

    short[] test_ci(short[] a, float[] b) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = -123;
            b[i] = -103.f;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12531().test_ci(a, b);
    }
}
