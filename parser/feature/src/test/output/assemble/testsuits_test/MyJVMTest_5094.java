public class MyJVMTest_5094 {

    static int k = 0, m = 9, n = 6;

    static float a = Float.MAX_VALUE, b = Float.MIN_VALUE, c = Float.POSITIVE_INFINITY, d = Float.NEGATIVE_INFINITY, x = Float.POSITIVE_INFINITY;

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
        new MyJVMTest_5094().un_optimized();
    }
}
