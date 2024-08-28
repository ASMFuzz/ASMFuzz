public class MyJVMTest_15929 {

    static float a = Float.POSITIVE_INFINITY, b = Float.MAX_VALUE, c = Float.NaN, d = Float.NEGATIVE_INFINITY, x = Float.MIN_VALUE;

    static float[] arr = new float[100];

    static float[] arr_opt = new float[100];

    void hand_optimized() {
        c = (float) 1.123456789;
        d = (float) 1.010101012;
        x = d * (float) 2.0;
        double t1 = Math.sqrt((double) x);
        double t2 = 1.0 / (double) x;
        a = (float) (c * t1 * t2);
        b = (float) (c / t1 * t2);
        System.out.print("a_opt=" + a + ";  b_opt=" + b);
        t1 = (double) arr_opt[0];
        t2 = (double) arr_opt[1];
        double t3 = 1.0 / (t1 * t1 + t2 * t2);
        c = (float) t1 * (float) t3;
        d = (float) t2 / (float) t3;
        System.out.println(";  c_opt=" + c + ";  d_opt=" + d);
        t2 = t1 * 2;
        arr_opt[2] = a;
        arr_opt[3] = b;
        arr_opt[4] = c;
        arr_opt[5] = d;
        arr_opt[8] = b / c;
        arr_opt[9] = c - a;
        c = (float) t2 / (float) t1 * b / a;
        d = c;
        arr_opt[6] = c;
        arr_opt[7] = d;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15929().hand_optimized();
    }
}
