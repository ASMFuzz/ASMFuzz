public class MyJVMTest_6852 {

    static short[] a = { -31381, -32768, -32768, 0, 32767, 8870, -22497, 32767, -32768, 1113 };

    static float[] b = { Float.NaN, Float.POSITIVE_INFINITY, Float.MIN_VALUE, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.MAX_VALUE, Float.MAX_VALUE, Float.POSITIVE_INFINITY, Float.MIN_VALUE, Float.NEGATIVE_INFINITY };

    static short c = -32768;

    static float d = Float.MAX_VALUE;

    short[] test_vi_oppos(short[] a, float[] b, short c, float d) {
        int limit = a.length - 1;
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = c;
            b[limit - i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6852().test_vi_oppos(a, b, c, d);
    }
}
