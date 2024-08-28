public class MyJVMTest_684 {

    static int[] a = { 5, 1582334876, 6, 1941033754, 1, 0, 2017741236, 4, 5, 1937129748 };

    static long[] b = { -9223372036854775808L, -7898129801675660740L, 9223372036854775807L, 0, 0, 0, 0, 9223372036854775807L, -9223372036854775808L, 9223372036854775807L };

    static int c = 0;

    static long d = -8965966990892772122L;

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    int[] test_vi_unaln(int[] a, long[] b, int c, long d) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i] = c;
            b[i + UNALIGN_OFF] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_684().test_vi_unaln(a, b, c, d);
    }
}
