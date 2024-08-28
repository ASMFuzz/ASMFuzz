public class MyJVMTest_7081 {

    static int[] a = { 0, 6, 0, 7, 0, 9, 1, -20238211, 7, -279992647 };

    static int[] b = { 1, -280315790, 1219640693, 483422957, 0, 8, 0, 0, 6, 3 };

    static long[] c = { 9223372036854775807L, -9223372036854775808L, 0, 9223372036854775807L, 7965625346291335204L, -9223372036854775808L, 0, 9223372036854775807L, 9223372036854775807L, 9223372036854775807L };

    static long[] d = { -9223372036854775808L, 7513196969072888700L, 9223372036854775807L, 0, -9223372036854775808L, 6868017523962991229L, 0, 9223372036854775807L, -9223372036854775808L, 3939884387433398486L };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    int[] test_cp_unalnsrc(int[] a, int[] b, long[] c, long[] d) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i] = b[i + UNALIGN_OFF];
            c[i] = d[i + UNALIGN_OFF];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7081().test_cp_unalnsrc(a, b, c, d);
    }
}
