public class MyJVMTest_11629 {

    static long[] a = { 0, 9223372036854775807L, 9223372036854775807L, 0, 3995692492249615424L, -9223372036854775808L, -1773260196876699159L, 0, -9223372036854775808L, 0 };

    static long[] b = { -6549767747430153264L, 2427196981823250778L, 9223372036854775807L, 0, 9223372036854775807L, -573312551567817499L, 3772844303497687489L, -9223372036854775808L, 9223372036854775807L, 9223372036854775807L };

    static int k = 7;

    int test_2ci_inv(long[] a, long[] b, int k) {
        for (int i = 0; i < a.length - k; i += 1) {
            a[i + k] = -123;
            b[i + k] = -103;
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11629().test_2ci_inv(a, b, k);
    }
}
