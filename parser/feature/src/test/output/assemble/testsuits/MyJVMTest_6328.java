public class MyJVMTest_6328 {

    static byte[] a = { -45, -38, 86, -8, -25, 90, -46, -23, 22, -74 };

    static short[] b = { 20620, 0, -32768, -13459, 0, 0, 32767, -32768, -27010, 32767 };

    static byte c = 127;

    static short d = 0;

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
        new MyJVMTest_6328().test_vi_unaln(a, b, c, d);
    }
}
