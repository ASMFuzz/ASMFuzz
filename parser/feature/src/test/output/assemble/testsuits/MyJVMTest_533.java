public class MyJVMTest_533 {

    static byte[] a = { -105, -49, 89, 21, 86, -69, -4, 122, -22, -66 };

    static short[] b = { -10291, 32767, -32768, 32767, -32768, 6699, -10048, 32767, 16844, 32767 };

    static byte c = -128;

    static short d = -25947;

    static int ALIGN_OFF = 8;

    byte[] test_vi_aln(byte[] a, short[] b, byte c, short d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i] = c;
            b[i + ALIGN_OFF] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_533().test_vi_aln(a, b, c, d);
    }
}
