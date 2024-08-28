public class MyJVMTest_12930 {

    static byte[] a = { 34, 8, -34, 50, -94, 27, 0, 31, -73, -6 };

    static int[] b = { 129930495, 8, 0, 1, 1, -676418376, -1771150746, 1143962094, 5, 0 };

    static byte c = 0;

    static int d = 930508694;

    byte[] test_vi(byte[] a, int[] b, byte c, int d) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = c;
            b[i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12930().test_vi(a, b, c, d);
    }
}
