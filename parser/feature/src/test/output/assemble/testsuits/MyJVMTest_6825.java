public class MyJVMTest_6825 {

    static int[] a = { 645140878, -1428224882, 1940840982, 0, 7, 2, 3, 2, 841681177, 0 };

    static long[] b = { -9223372036854775808L, -7226228857021873984L, 9223372036854775807L, 9223372036854775807L, 0, 9223372036854775807L, 6795077321980855474L, -5772625935729163995L, -9223372036854775808L, 7802549544637088929L };

    static int c = 7;

    static long d = -9223372036854775808L;

    int[] test_vi_neg(int[] a, long[] b, int c, long d) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = c;
            b[i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6825().test_vi_neg(a, b, c, d);
    }
}
