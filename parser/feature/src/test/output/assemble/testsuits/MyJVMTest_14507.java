public class MyJVMTest_14507 {

    static int k = 1, m = 7, n = 0;

    static float a = Float.MIN_VALUE, b = Float.POSITIVE_INFINITY, c = 0.9517362f, d = Float.MIN_VALUE, x = Float.NaN;

    static float[] arr = new float[100];

    void un_optimized() {
        c = (float) 1.123456789;
        d = (float) 1.010101012;
        a = (float) ((c * Math.sqrt(d * 2.0)) / (2.0 * d));
        b = (float) ((c / Math.sqrt(d * 2.0)) / (2.0 * d));
        System.out.print("a=" + a + ";  b=" + b);
        c = arr[0] / (arr[0] * arr[0] + arr[1] * arr[1]);
        d = arr[1] * (arr[0] * arr[0] + arr[1] * arr[1]);
        System.out.println(";  c=" + c + ";  d=" + d);
        k = 0;
        float t1 = arr[k];
        float t2 = arr[k] * 2;
        arr[2] = a;
        arr[3] = b;
        arr[4] = c;
        arr[5] = d;
        arr[8] = b / c;
        arr[9] = c - a;
        c = t2 / t1 * b / a;
        x = (float) (d * 2.0);
        d = t2 / t1 * b / a;
        arr[6] = c;
        arr[7] = d;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14507().un_optimized();
    }
}
