public class MyJVMTest_1297 {

    static int[] a = { 0, 3, 8, 9, 9, 4, 0, 6, 0, 0 };

    static int[] b = { 4, 0, 0, 293616698, -808375069, 1, 7, 6, 0, 2 };

    static long[] c = { 8565552520501256146L, -9223372036854775808L, -9223372036854775808L, 9223372036854775807L, -3213188362798104148L, 3766296069410111660L, 0, -9223372036854775808L, -9223372036854775808L, 0 };

    static long[] d = { -9223372036854775808L, -9223372036854775808L, -9223372036854775808L, 0, -9223372036854775808L, 0, -9223372036854775808L, 9223372036854775807L, -9223372036854775808L, 0 };

    int[] test_cp_neg(int[] a, int[] b, long[] c, long[] d) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = b[i];
            c[i] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1297().test_cp_neg(a, b, c, d);
    }
}
