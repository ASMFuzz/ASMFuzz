public class MyJVMTest_12613 {

    static int[] a = { 7, 5, 4, 0, 0, -1446105734, 685034810, 8, 0, 1 };

    static long[] b = { 9223372036854775807L, 0, -9223372036854775808L, 9223372036854775807L, 0, 9223372036854775807L, 9223372036854775807L, 9223372036854775807L, 9223372036854775807L, 0 };

    int[] test_ci(int[] a, long[] b) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = -123;
            b[i] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12613().test_ci(a, b);
    }
}
