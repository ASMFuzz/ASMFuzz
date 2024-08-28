public class MyJVMTest_10711 {

    static short[] a = { 32767, 12773, -19160, 32767, -32768, 6705, 18372, 0, 0, 32767 };

    static short[] b = { -32768, -32768, 32767, 31422, 0, 0, -16211, -32390, 0, 32767 };

    static float[] c = { 0.12245542f, Float.MAX_VALUE, Float.MAX_VALUE, Float.MIN_VALUE, Float.NEGATIVE_INFINITY, 0f, 0f, 0f, Float.MIN_VALUE, Float.POSITIVE_INFINITY };

    static float[] d = { 0.3317569f, Float.NEGATIVE_INFINITY, 0f, Float.MIN_VALUE, Float.MIN_VALUE, Float.POSITIVE_INFINITY, 0f, Float.MIN_VALUE, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY };

    short[] test_cp_oppos(short[] a, short[] b, float[] c, float[] d) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b[limit - i];
            c[limit - i] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10711().test_cp_oppos(a, b, c, d);
    }
}
