public class MyJVMTest_3515 {

    static int[] a = { -1543876945, 0, 2, 0, 0, 5, 9, 1986411506, -1691198380, 0 };

    static long[] b = { -9223372036854775808L, 9223372036854775807L, -9223372036854775808L, 9223372036854775807L, 9223372036854775807L, -9223372036854775808L, 0, 9223372036854775807L, 9223372036854775807L, 9223372036854775807L };

    static int c = 8;

    static long d = -9223372036854775808L;

    int[] test_vi_oppos(int[] a, long[] b, int c, long d) {
        int limit = a.length - 1;
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = c;
            b[limit - i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3515().test_vi_oppos(a, b, c, d);
    }
}
