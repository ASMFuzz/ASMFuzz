public class MyJVMTest_1024 {

    static int[] a = { 3, 6, 0, 753987275, -363806786, 1463737111, 0, 1, 0, 1 };

    static long[] b = { 0, -5938398528454702971L, 2422608452437499149L, 0, 9223372036854775807L, -7364425003632381801L, 0, -9223372036854775808L, -9223372036854775808L, -9223372036854775808L };

    int[] test_ci_neg(int[] a, long[] b) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = -123;
            b[i] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1024().test_ci_neg(a, b);
    }
}
