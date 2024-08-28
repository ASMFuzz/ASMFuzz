public class MyJVMTest_6806 {

    static byte[] a = { 108, -13, 61, 45, 125, -111, -25, 108, 98, -100 };

    static byte[] b = { -40, 57, -57, -4, 127, 83, 98, -113, -89, 56 };

    static byte c = 0;

    static byte d = -128;

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    byte[] test_2vi_unaln(byte[] a, byte[] b, byte c, byte d) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i] = c;
            b[i + UNALIGN_OFF] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6806().test_2vi_unaln(a, b, c, d);
    }
}
