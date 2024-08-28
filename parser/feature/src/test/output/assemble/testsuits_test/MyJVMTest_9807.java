public class MyJVMTest_9807 {

    static short[] a = { 4496, 0, 0, -32768, 32767, -21514, 32767, -11532, -32768, 32767 };

    static long[] b = { 9223372036854775807L, -1379771424105779614L, 9223372036854775807L, 0, 0, -3153220730065977121L, 9223372036854775807L, -9223372036854775808L, 4607376876137109536L, 0 };

    static int ALIGN_OFF = 8;

    short[] test_ci_aln(short[] a, long[] b) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i + ALIGN_OFF] = -123;
            b[i] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9807().test_ci_aln(a, b);
    }
}
