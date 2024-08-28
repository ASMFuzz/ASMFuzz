public class MyJVMTest_16325 {

    static byte[] a = { 73, 30, 65, 122, -43, -35, -125, 49, 69, 80 };

    static double[] b = { Double.NEGATIVE_INFINITY, Double.MIN_VALUE, 0.6289946160543295, 0d, 0d, 0d, 0d, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY };

    static byte c = 127;

    static double d = Double.NEGATIVE_INFINITY;

    byte[] test_vi_oppos(byte[] a, double[] b, byte c, double d) {
        int limit = a.length - 1;
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = c;
            b[limit - i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16325().test_vi_oppos(a, b, c, d);
    }
}
