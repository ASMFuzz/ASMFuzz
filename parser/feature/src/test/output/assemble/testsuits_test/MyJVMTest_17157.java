public class MyJVMTest_17157 {

    static short[] a = { 0, -29476, -32768, 23670, 32767, 30090, 32767, 32767, -32768, 32767 };

    static long[] b = { -9223372036854775808L, -9223372036854775808L, 9223372036854775807L, 9223372036854775807L, 9120346670924739903L, 0, -3114527574640644404L, 0, 9223372036854775807L, 0 };

    static short c = 32767;

    static long d = 0;

    static int ALIGN_OFF = 8;

    short[] test_vi_aln(short[] a, long[] b, short c, long d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i] = c;
            b[i + ALIGN_OFF] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17157().test_vi_aln(a, b, c, d);
    }
}
