public class MyJVMTest_6335 {

    static byte[] a = { 6, 17, -26, -41, -66, 26, 72, -92, 75, -18 };

    static byte[] b = { 40, -58, 42, -93, 87, -79, -35, 118, -127, -76 };

    static int[] c = { 0, 5, 8, 0, -1974945083, 4, 1, 0, 0, 9 };

    static int[] d = { 2, 5, 1, 0, 8, 9, -2605208, -121396749, 1222544966, 3 };

    byte[] test_cp_neg(byte[] a, byte[] b, int[] c, int[] d) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = b[i];
            c[i] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6335().test_cp_neg(a, b, c, d);
    }
}
