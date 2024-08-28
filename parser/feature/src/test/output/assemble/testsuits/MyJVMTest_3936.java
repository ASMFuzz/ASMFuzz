public class MyJVMTest_3936 {

    static byte[] a = { 118, 25, -79, 6, -104, -4, -107, -112, -64, 43 };

    static byte[] b = { 6, 67, 0, -77, -72, -81, 34, -74, -106, 62 };

    static short[] c = { 0, -32768, -32768, 0, -22990, 32767, 32767, 32767, -32768, 0 };

    static short[] d = { 0, -32768, -32768, 0, 32767, 0, -32768, -32768, 0, 0 };

    byte[] test_cp_neg(byte[] a, byte[] b, short[] c, short[] d) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = b[i];
            c[i] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3936().test_cp_neg(a, b, c, d);
    }
}
