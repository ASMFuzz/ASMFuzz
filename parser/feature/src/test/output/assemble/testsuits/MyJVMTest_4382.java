public class MyJVMTest_4382 {

    static int k = 592257211, m = 8, n = 8;

    static double a = Double.MAX_VALUE, b = Double.NaN, c = Double.NaN, d = 0d;

    static double[] arr = new double[100];

    static double[][] arr1 = new double[10][10];

    void un_optimized() {
        c = 1.123456789;
        d = 1.010101012;
        b = 1E-8;
        if (c == d) {
            a = d * c * (b * 10.0);
        } else {
            a = d / c * (b * 10.0);
        }
        if ((a * c) > 9.0) {
            b = a * c / 10.0;
            c = 1.0;
        } else {
            b = a * c;
            c = 0.1;
        }
        int n = 9;
        for (k = 0; k < arr.length; k++) {
            n = n - 1;
            if (n < 0)
                n = 9;
            if (arr1[0][n] == arr[k])
                break;
        }
        if (arr1[0][n] == b)
            c += 1.0;
        arr[2] = a;
        arr[3] = arr1[0][n];
        arr[4] = c;
        arr[5] = d;
        arr[8] = a / c;
        arr[9] = c - a;
        b = d * c;
        d = d * c;
        arr[6] = b;
        arr[7] = d;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4382().un_optimized();
    }
}
