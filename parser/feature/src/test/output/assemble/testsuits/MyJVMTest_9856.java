public class MyJVMTest_9856 {

    static int[] a = { -2069571227, -936886722, 0, 6, 0, 0, 8, 0, 9, 3 };

    static long[] b = { 0, 0, -9223372036854775808L, -9223372036854775808L, -9223372036854775808L, -9223372036854775808L, 9223372036854775807L, -8857552932939622400L, 0, 9223372036854775807L };

    static int c = 2;

    static long d = -9223372036854775808L;

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
        new MyJVMTest_9856().test_vi_unaln(a, b, c, d);
    }
}
