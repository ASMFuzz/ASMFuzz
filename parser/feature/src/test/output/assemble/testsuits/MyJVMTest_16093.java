public class MyJVMTest_16093 {

    static byte[] a = { -50, 86, -52, -128, 124, -29, -94, 100, -13, -127 };

    static byte[] b = { -118, 77, 9, 16, 50, -97, 101, -77, -125, -33 };

    static float[] c = { Float.MAX_VALUE, Float.POSITIVE_INFINITY, Float.MAX_VALUE, 0.13970542f, 0.28895158f, 0f, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, 0f, Float.MAX_VALUE };

    static float[] d = { 0.0831095f, 0.2003237f, Float.NEGATIVE_INFINITY, Float.NaN, Float.MIN_VALUE, Float.MIN_VALUE, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, 0.42714697f, Float.NEGATIVE_INFINITY };

    byte[] test_cp_oppos(byte[] a, byte[] b, float[] c, float[] d) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b[limit - i];
            c[limit - i] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16093().test_cp_oppos(a, b, c, d);
    }
}
