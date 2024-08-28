public class MyJVMTest_6384 {

    static byte[] a = { -77, -96, -115, 14, 51, -108, 73, 20, -104, 65 };

    static long[] b = { 0, -9223372036854775808L, 9223372036854775807L, -9223372036854775808L, 3628658444138001082L, 9223372036854775807L, 0, 0, -9223372036854775808L, 5205971469397930215L };

    byte[] test_ci_oppos(byte[] a, long[] b) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[limit - i] = -123;
            b[i] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6384().test_ci_oppos(a, b);
    }
}
