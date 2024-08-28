public class MyJVMTest_2631 {

    static byte[] a = { -77, -118, -5, -33, 15, 123, 76, -69, -11, 51 };

    static short[] b = { -3097, -32768, 0, -32768, 32767, -6489, -32768, -32768, -32768, 0 };

    static int ALIGN_OFF = 8;

    byte[] test_ci_aln(byte[] a, short[] b) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i + ALIGN_OFF] = -123;
            b[i] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2631().test_ci_aln(a, b);
    }
}
