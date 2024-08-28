public class MyJVMTest_15866 {

    static byte[] a = { 75, 75, -114, -117, 72, -116, -117, 34, 92, -95 };

    static long[] b = { -2806509571785423834L, -4021624863608614971L, -9223372036854775808L, 7649360451969017036L, 9223372036854775807L, 9223372036854775807L, 9223372036854775807L, 9223372036854775807L, 9223372036854775807L, 9223372036854775807L };

    byte[] test_ci_oppos(byte[] a, long[] b) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[limit - i] = -123;
            b[i] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15866().test_ci_oppos(a, b);
    }
}
