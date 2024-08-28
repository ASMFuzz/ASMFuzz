public class MyJVMTest_1269 {

    static byte[] a = { -85, 81, 102, -11, -50, 104, 53, -49, -92, 106 };

    static byte[] b = { 73, 74, -108, 64, -59, -106, -87, 91, -98, 59 };

    static int ALIGN_OFF = 8;

    byte[] test_cp_alndst(byte[] a, byte[] b) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i + ALIGN_OFF] = b[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1269().test_cp_alndst(a, b);
    }
}
