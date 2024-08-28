public class MyJVMTest_14356 {

    static byte[] a = { 88, 107, -99, -99, 32, -80, 49, -108, 78, 47 };

    static long[] b = { 9223372036854775807L, 9223372036854775807L, 9223372036854775807L, -3762285968528191490L, 9223372036854775807L, 0, 0, -9223372036854775808L, -9223372036854775808L, -9223372036854775808L };

    static byte c = 0;

    static long d = 6717710902568703194L;

    static int ALIGN_OFF = 8;

    byte[] test_vi_aln(byte[] a, long[] b, byte c, long d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i] = c;
            b[i + ALIGN_OFF] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14356().test_vi_aln(a, b, c, d);
    }
}
