public class MyJVMTest_11179 {

    static int k = 2, m = 1, n = 6;

    static double a = Double.NaN, b = 0d, c = Double.MIN_VALUE, d = Double.MIN_VALUE;

    static double[] arr = new double[100];

    static double[] arr_opt = new double[100];

    static double[][] arr1 = new double[10][10];

    static double[][] arr1_opt = new double[10][10];

    void hand_optimized() {
        c = 1.123456789;
        d = 1.010101012;
        b = 1E-8;
        if (c == d) {
            a = d * c;
        } else {
            a = d / c;
        }
        a *= (b * 10.0);
        b = a * c;
        if (b > 9.0) {
            b /= 10.0;
            c = 1.0;
        } else {
            c = 0.1;
        }
        double t1 = arr1_opt[0][n];
        n = 9;
        for (k = 0; k < arr_opt.length; k++) {
            n--;
            if (n < 0)
                n = 9;
            if (t1 == arr_opt[k])
                break;
        }
        if (t1 == b)
            c++;
        arr_opt[2] = a;
        arr_opt[3] = t1;
        arr_opt[4] = c;
        arr_opt[5] = d;
        arr_opt[8] = a / c;
        arr_opt[9] = c - a;
        b = d * c;
        d = b;
        arr_opt[6] = b;
        arr_opt[7] = d;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11179().hand_optimized();
    }
}
