public class MyJVMTest_15806 {

    static byte[] a = { 59, 43, -87, 68, -114, 21, 37, -25, 116, -112 };

    static short[] b = { 15396, -32768, -6118, -15900, 0, -32768, -20853, -32768, 0, 32767 };

    static byte c = 127;

    static short d = 29194;

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    byte[] test_vi_unaln(byte[] a, short[] b, byte c, short d) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i] = c;
            b[i + UNALIGN_OFF] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15806().test_vi_unaln(a, b, c, d);
    }
}
