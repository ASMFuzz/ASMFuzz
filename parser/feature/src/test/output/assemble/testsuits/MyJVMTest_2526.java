public class MyJVMTest_2526 {

    static int[] a = { 0, 0, 3, -1340781748, 1582915674, 0, -768377453, -260928439, 0, -1667998645 };

    static int[] b = { 9, 2, 5, 0, 7, 0, 1, 0, 5, 1562089974 };

    static long[] c = { -9223372036854775808L, 9223372036854775807L, -9223372036854775808L, -9223372036854775808L, 0, 9223372036854775807L, -9223372036854775808L, -9223372036854775808L, -3677589796683522287L, 0 };

    static long[] d = { -9223372036854775808L, -9223372036854775808L, -9223372036854775808L, -9223372036854775808L, 0, -9223372036854775808L, -2621541695894226672L, -9223372036854775808L, -1310379500212271026L, 0 };

    static int ALIGN_OFF = 8;

    int[] test_cp_alndst(int[] a, int[] b, long[] c, long[] d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i + ALIGN_OFF] = b[i];
            c[i + ALIGN_OFF] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2526().test_cp_alndst(a, b, c, d);
    }
}
