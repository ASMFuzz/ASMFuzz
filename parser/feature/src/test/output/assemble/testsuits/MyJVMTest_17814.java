public class MyJVMTest_17814 {

    static byte[] a = { -85, -110, 65, 8, -52, 33, -6, 103, -86, -112 };

    static long[] b = { -9223372036854775808L, -9223372036854775808L, 9223372036854775807L, -3451429029004156944L, 0, -9223372036854775808L, 7724379814228411969L, 0, 286210037373222428L, 0 };

    static int ALIGN_OFF = 8;

    byte[] test_ci_aln(byte[] a, long[] b) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i + ALIGN_OFF] = -123;
            b[i] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17814().test_ci_aln(a, b);
    }
}
