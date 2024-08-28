public class MyJVMTest_7402 {

    static byte[] a = { 36, 62, -105, 3, 50, 10, 39, 94, 16, -110 };

    static byte[] b = { -110, 28, -64, -116, -7, -27, 4, -24, -118, -30 };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    byte[] test_cp_unalndst(byte[] a, byte[] b) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i + UNALIGN_OFF] = b[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7402().test_cp_unalndst(a, b);
    }
}
