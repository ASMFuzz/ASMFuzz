public class MyJVMTest_14792 {

    static short[] a = { -32768, 0, 32767, -16773, 0, 32767, -32768, -32768, 0, 32767 };

    static double[] b = { 0.028130219473712526, Double.MAX_VALUE, Double.MAX_VALUE, Double.NaN, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, 0d, Double.NaN, 0.2089915939330771, 0d };

    static short c = -32768;

    static double d = Double.MAX_VALUE;

    short[] test_vi(short[] a, double[] b, short c, double d) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = c;
            b[i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14792().test_vi(a, b, c, d);
    }
}
