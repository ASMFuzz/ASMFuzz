public class MyJVMTest_13300 {

    static byte[] a = { -84, -65, 58, 4, -23, 118, -31, -30, -117, -104 };

    static byte[] b = { -90, 17, -38, -97, -109, -35, -101, -43, -51, -80 };

    static byte c = -128;

    static byte d = 0;

    byte[] test_2vi_neg(byte[] a, byte[] b, byte c, byte d) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = c;
            b[i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13300().test_2vi_neg(a, b, c, d);
    }
}
