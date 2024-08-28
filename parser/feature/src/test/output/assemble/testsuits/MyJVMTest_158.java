public class MyJVMTest_158 {

    static long[] a = { 1525368196358419844L, 9223372036854775807L, -9223372036854775808L, 9223372036854775807L, -3595489455634202597L, 9223372036854775807L, 9223372036854775807L, 9223372036854775807L, -9223372036854775808L, -7228384013969596190L };

    static long[] b = { 9223372036854775807L, -2965174296485889895L, 9223372036854775807L, -9223372036854775808L, -9223372036854775808L, -9223372036854775808L, 0, 0, -9223372036854775808L, -9223372036854775808L };

    static long c = -9223372036854775808L;

    static long d = 0;

    static int ALIGN_OFF = 8;

    long[] test_2vi_aln(long[] a, long[] b, long c, long d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i] = c;
            b[i + ALIGN_OFF] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_158().test_2vi_aln(a, b, c, d);
    }
}
