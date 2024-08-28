public class MyJVMTest_14345 {

    static byte[] a = { -72, -43, -46, -106, -4, 24, 13, 117, -19, -57 };

    static byte[] b = { -113, 93, 83, -17, -55, 80, -18, -110, 37, 106 };

    static byte c = -128;

    static byte d = -128;

    static int OFFSET = 3;

    byte[] test_2vi_off(byte[] a, byte[] b, byte c, byte d) {
        for (int i = 0; i < a.length - OFFSET; i += 1) {
            a[i + OFFSET] = c;
            b[i + OFFSET] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14345().test_2vi_off(a, b, c, d);
    }
}
