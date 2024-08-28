public class MyJVMTest_4950 {

    static byte[] a = { -84, -91, -119, -21, 122, -111, -87, -96, 75, 102 };

    static long[] b = { 1715704366246951997L, -863527840476009477L, 0, -4379115181396402423L, 9223372036854775807L, -5810645678297407910L, -9223372036854775808L, 0, -9223372036854775808L, 0 };

    static byte c = 127;

    static long d = -5645453397720918219L;

    static int ALIGN_OFF = 8;

    byte[] test_vi_aln(byte[] a, long[] b, byte c, long d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i] = c;
            b[i + ALIGN_OFF] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4950().test_vi_aln(a, b, c, d);
    }
}
