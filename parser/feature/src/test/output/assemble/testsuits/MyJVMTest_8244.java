public class MyJVMTest_8244 {

    static short[] a = { 32767, -32768, 0, 0, 32767, 0, 0, 0, -28087, -32768 };

    static short[] b = { 32767, -27033, 0, 32767, -24897, 3257, -29279, 14858, -32768, -8953 };

    static double[] c = { Double.MIN_VALUE, Double.MIN_VALUE, Double.NEGATIVE_INFINITY, 0.45668420835603707, Double.NaN, Double.NaN, Double.MIN_VALUE, 0.23047348017498903, 0d, Double.MAX_VALUE };

    static double[] d = { Double.NEGATIVE_INFINITY, 0.20962607631685304, Double.NaN, 0.5315489534548231, 0.7755090798120818, 0.2018173650746019, Double.NEGATIVE_INFINITY, 0.1867086882519422, Double.MAX_VALUE, Double.NaN };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    short[] test_cp_unalnsrc(short[] a, short[] b, double[] c, double[] d) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i] = b[i + UNALIGN_OFF];
            c[i] = d[i + UNALIGN_OFF];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8244().test_cp_unalnsrc(a, b, c, d);
    }
}
