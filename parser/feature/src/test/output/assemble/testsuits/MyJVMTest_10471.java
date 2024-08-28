public class MyJVMTest_10471 {

    static byte[] a = { -68, 40, 29, 36, -31, -82, 98, -29, 39, 1 };

    static byte[] b = { -32, 68, 116, -22, -97, -28, 48, -24, 123, 45 };

    static int ALIGN_OFF = 8;

    byte[] test_cp_alndst(byte[] a, byte[] b) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i + ALIGN_OFF] = b[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10471().test_cp_alndst(a, b);
    }
}
