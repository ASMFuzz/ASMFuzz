public class MyJVMTest_16934 {

    static byte[] a = { -23, 62, -24, 102, 68, 123, 42, -22, -36, 122 };

    static byte[] b = { -51, 13, 127, 59, -45, -71, 127, -62, 49, 95 };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    byte[] test_cp_unalndst(byte[] a, byte[] b) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i + UNALIGN_OFF] = b[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16934().test_cp_unalndst(a, b);
    }
}
