public class MyJVMTest_11913 {

    static byte[] a = { 72, -42, -10, 99, -126, 49, -36, -81, 97, 120 };

    static short[] b = { 0, -32768, 32767, 0, -32768, 20338, 0, -32768, 24013, -32768 };

    static int ALIGN_OFF = 8;

    byte[] test_ci_aln(byte[] a, short[] b) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i + ALIGN_OFF] = -123;
            b[i] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11913().test_ci_aln(a, b);
    }
}
