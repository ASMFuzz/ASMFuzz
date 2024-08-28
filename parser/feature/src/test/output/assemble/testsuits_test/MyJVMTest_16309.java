public class MyJVMTest_16309 {

    static byte[] a = { -62, -48, 66, 76, -104, 69, 92, 81, 40, -32 };

    static byte[] b = { 45, 70, -125, -24, -67, -59, 74, -123, -80, 95 };

    static byte c = 127;

    static byte d = 127;

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
        new MyJVMTest_16309().test_2vi_unaln(a, b, c, d);
    }
}
