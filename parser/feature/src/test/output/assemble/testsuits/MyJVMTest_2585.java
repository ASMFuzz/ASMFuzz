public class MyJVMTest_2585 {

    static float[] a = { Float.POSITIVE_INFINITY, Float.MAX_VALUE, 0.20113468f, Float.NEGATIVE_INFINITY, Float.NaN, Float.MAX_VALUE, Float.MAX_VALUE, Float.MAX_VALUE, 0f, Float.NEGATIVE_INFINITY };

    static float[] b = { Float.NaN, Float.MAX_VALUE, Float.POSITIVE_INFINITY, Float.MIN_VALUE, Float.MIN_VALUE, 0f, Float.POSITIVE_INFINITY, 0f, Float.MIN_VALUE, 0.69045025f };

    static double[] c = { Double.NaN, 0.17704224384563505, 0d, Double.POSITIVE_INFINITY, Double.NaN, 0d, 0d, Double.NaN, Double.POSITIVE_INFINITY, Double.NaN };

    static double[] d = { Double.MAX_VALUE, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NaN, Double.NaN, 0.3430954050497207, Double.MIN_VALUE, 0.6720381763929152, 0d, Double.NEGATIVE_INFINITY };

    float[] test_cp_oppos(float[] a, float[] b, double[] c, double[] d) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b[limit - i];
            c[limit - i] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2585().test_cp_oppos(a, b, c, d);
    }
}
