public class MyJVMTest_15596 {

    static short[] a = { -32768, 0, 0, 32767, 0, 32767, -32768, -32768, 0, -32768 };

    static double[] b = { Double.MAX_VALUE, 0.2713342721862446, Double.MIN_VALUE, Double.MAX_VALUE, 0.6850235689172947, Double.NEGATIVE_INFINITY, 0.9020947090394033, 0.7947090928066608, Double.MAX_VALUE, Double.MAX_VALUE };

    short[] test_ci_oppos(short[] a, double[] b) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[limit - i] = -123;
            b[i] = -103.;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15596().test_ci_oppos(a, b);
    }
}
