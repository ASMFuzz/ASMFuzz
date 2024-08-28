public class MyJVMTest_15641 {

    static float[] a = { 0.29619306f, Float.MAX_VALUE, Float.POSITIVE_INFINITY, Float.NaN, Float.MAX_VALUE, Float.MAX_VALUE, Float.NaN, Float.POSITIVE_INFINITY, Float.NaN, Float.MAX_VALUE };

    static float[] b = { Float.NEGATIVE_INFINITY, 0f, Float.MAX_VALUE, 0f, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.MIN_VALUE, Float.NEGATIVE_INFINITY, 0.79325646f, 0f };

    static float[] c = { Float.POSITIVE_INFINITY, Float.MAX_VALUE, 0.64077103f, 0.5426251f, 0.6347444f, Float.NaN, Float.NaN, 0.1966942f, Float.NEGATIVE_INFINITY, Float.NaN };

    float[] sumReductionInit(float[] a, float[] b, float[] c) {
        for (int j = 0; j < 1; j++) {
            for (int i = 0; i < a.length; i++) {
                a[i] = i * 1 + j;
                b[i] = i * 1 - j;
                c[i] = i + j;
            }
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15641().sumReductionInit(a, b, c);
    }
}
