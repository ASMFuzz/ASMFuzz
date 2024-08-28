public class MyJVMTest_2601 {

    static byte[] a = { -30, 78, -120, 117, 106, 117, 16, 112, 114, -72 };

    static byte[] b = { 0, 83, -74, -99, 48, -65, 108, 4, -86, -120 };

    static int ALIGN_OFF = 8;

    byte[] test_2ci_aln(byte[] a, byte[] b) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i + ALIGN_OFF] = -123;
            b[i] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2601().test_2ci_aln(a, b);
    }
}
