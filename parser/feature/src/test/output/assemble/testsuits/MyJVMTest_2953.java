public class MyJVMTest_2953 {

    static byte[] a = { -99, -104, 65, 10, -110, -22, -121, -2, -24, 108 };

    static byte[] b = { -64, 89, 58, 60, 25, -11, -102, -52, -53, -38 };

    static byte c = 0;

    static byte d = 127;

    static int SCALE = 2;

    byte[] test_2vi_scl(byte[] a, byte[] b, byte c, byte d) {
        for (int i = 0; i * SCALE < a.length; i += 1) {
            a[i * SCALE] = c;
            b[i * SCALE] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2953().test_2vi_scl(a, b, c, d);
    }
}
