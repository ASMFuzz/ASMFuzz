public class MyJVMTest_12257 {

    static byte[] a = { 24, 32, -125, -113, -85, 55, -116, -77, -10, -91 };

    static short[] b = { 32767, 0, 32767, 32767, 0, -1257, 0, 32767, 0, 1935 };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    byte[] test_ci_unaln(byte[] a, short[] b) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i + UNALIGN_OFF] = -123;
            b[i] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12257().test_ci_unaln(a, b);
    }
}
