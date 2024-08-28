public class MyJVMTest_1823 {

    static byte[] a = { 80, -106, -97, -119, -59, 101, -62, 100, 102, -126 };

    static byte[] b = { 113, 103, -115, -90, -14, 8, -113, 15, 71, -80 };

    static short[] c = { 12304, 0, 32767, 0, 0, 32767, -27832, -14424, -32768, 4703 };

    static short[] d = { -32768, 0, 3197, 32767, 32767, 32767, 0, 29015, -32768, -32768 };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    byte[] test_cp_unalndst(byte[] a, byte[] b, short[] c, short[] d) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i + UNALIGN_OFF] = b[i];
            c[i + UNALIGN_OFF] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1823().test_cp_unalndst(a, b, c, d);
    }
}
