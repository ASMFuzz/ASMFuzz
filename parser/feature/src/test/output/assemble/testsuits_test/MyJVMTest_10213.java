public class MyJVMTest_10213 {

    static int[] a = { 7, 0, 4, -1557531105, 0, 1, 0, 0, 2, 0 };

    static long[] b = { 0, -8712734244051815213L, 5972230707343751364L, 9223372036854775807L, 9223372036854775807L, 4110675749459433545L, -9223372036854775808L, -9223372036854775808L, -9223372036854775808L, -9223372036854775808L };

    int[] test_ci_neg(int[] a, long[] b) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = -123;
            b[i] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10213().test_ci_neg(a, b);
    }
}
