public class MyJVMTest_16470 {

    static byte[] a = { 59, -98, -7, 40, -91, 118, 31, 74, -107, 46 };

    static int[] b = { 801529087, 0, 0, 0, -705927796, 4, 0, -155917679, 7, 0 };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    byte[] test_ci_unaln(byte[] a, int[] b) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i + UNALIGN_OFF] = -123;
            b[i] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16470().test_ci_unaln(a, b);
    }
}
