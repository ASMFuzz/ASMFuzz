public class MyJVMTest_3951 {

    static byte[] a = { -93, 116, -62, -43, 34, 124, 48, 69, 12, -48 };

    static byte[] b = { -105, 48, -7, -112, -105, -62, -95, -90, -58, -38 };

    static byte c = 127;

    static byte d = -128;

    byte[] test_2vi_neg(byte[] a, byte[] b, byte c, byte d) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = c;
            b[i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3951().test_2vi_neg(a, b, c, d);
    }
}
