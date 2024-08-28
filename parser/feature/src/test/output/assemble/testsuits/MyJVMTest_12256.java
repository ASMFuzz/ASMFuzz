public class MyJVMTest_12256 {

    static byte[] a = { -118, -3, 19, 112, 100, -39, 30, 76, -44, 70 };

    static byte[] b = { 115, -104, -38, 44, 80, -4, 110, -119, -6, 78 };

    static byte c = 0;

    static byte d = -38;

    static int SCALE = 2;

    byte[] test_2vi_scl(byte[] a, byte[] b, byte c, byte d) {
        for (int i = 0; i * SCALE < a.length; i += 1) {
            a[i * SCALE] = c;
            b[i * SCALE] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12256().test_2vi_scl(a, b, c, d);
    }
}
