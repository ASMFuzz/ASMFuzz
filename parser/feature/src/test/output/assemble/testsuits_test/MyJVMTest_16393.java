public class MyJVMTest_16393 {

    static byte[] a = { 37, 26, -66, 42, -16, 36, 114, -45, -99, 44 };

    static long[] b = { 9223372036854775807L, 0, 1129485024949857202L, -9223372036854775808L, 0, 0, 9223372036854775807L, 9223372036854775807L, 0, -4488110629947741357L };

    byte[] test_ci_neg(byte[] a, long[] b) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = -123;
            b[i] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16393().test_ci_neg(a, b);
    }
}
