public class MyJVMTest_1135 {

    static int[] a = { 0, 3, 0, 3, 8, 7, 1, 0, 7, 5 };

    static long[] b = { 9223372036854775807L, 9223372036854775807L, 2040051084735329732L, 9223372036854775807L, -9223372036854775808L, 9223372036854775807L, 0, 9223372036854775807L, 0, 9223372036854775807L };

    int[] test_ci_oppos(int[] a, long[] b) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[limit - i] = -123;
            b[i] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1135().test_ci_oppos(a, b);
    }
}
