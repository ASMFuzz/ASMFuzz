public class MyJVMTest_12849 {

    static int[] a = { 0, -2032160917, 0, 8, -1211887277, 0, 9, 0, 0, 0 };

    static long[] b = { -9223372036854775808L, 9223372036854775807L, 0, -9223372036854775808L, -9223372036854775808L, 5827285517901513998L, 9223372036854775807L, 0, 7362138665963077938L, 0 };

    static int c = 3;

    static long d = 0;

    int[] test_vi_oppos(int[] a, long[] b, int c, long d) {
        int limit = a.length - 1;
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = c;
            b[limit - i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12849().test_vi_oppos(a, b, c, d);
    }
}
