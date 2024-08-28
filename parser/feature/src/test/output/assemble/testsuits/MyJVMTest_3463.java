public class MyJVMTest_3463 {

    static int[] a = { 556915985, 2, 2, 900696612, 1684363223, 2, 5, 5, 0, 0 };

    static int[] b = { 730258701, -342356005, 113840443, -10254036, 357288472, 0, 8, 6, 6, 0 };

    static long[] c = { -9223372036854775808L, 0, 22263985957384577L, 238473444466769572L, -343487768736494739L, 9223372036854775807L, 0, 9223372036854775807L, 0, 0 };

    static long[] d = { -6022368001877671318L, 9223372036854775807L, 9223372036854775807L, 9223372036854775807L, 0, -9223372036854775808L, 0, 0, -9223372036854775808L, -9223372036854775808L };

    int[] test_cp_oppos(int[] a, int[] b, long[] c, long[] d) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b[limit - i];
            c[limit - i] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3463().test_cp_oppos(a, b, c, d);
    }
}
