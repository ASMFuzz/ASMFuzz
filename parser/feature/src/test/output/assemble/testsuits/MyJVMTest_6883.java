public class MyJVMTest_6883 {

    static byte[] a = { 46, 77, 36, -79, 8, 29, 43, 110, -79, 123 };

    static long[] b = { -9223372036854775808L, -9223372036854775808L, -9223372036854775808L, 9223372036854775807L, -4894057133707515192L, 0, 9223372036854775807L, 618179235712002264L, -9223372036854775808L, -9223372036854775808L };

    byte[] test_ci_neg(byte[] a, long[] b) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = -123;
            b[i] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6883().test_ci_neg(a, b);
    }
}
