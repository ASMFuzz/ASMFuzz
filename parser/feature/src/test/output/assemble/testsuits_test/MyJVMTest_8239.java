public class MyJVMTest_8239 {

    static byte[] a = { -93, 87, 91, -54, -95, -4, -96, -116, 103, -120 };

    static long[] b = { 9223372036854775807L, 7017129322419316938L, 9223372036854775807L, 0, -6743254871356571877L, 0, -9223372036854775808L, 0, 0, -2488509988906225673L };

    static int ALIGN_OFF = 8;

    byte[] test_ci_aln(byte[] a, long[] b) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i + ALIGN_OFF] = -123;
            b[i] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8239().test_ci_aln(a, b);
    }
}
