public class MyJVMTest_7653 {

    static byte[] a = { 41, 119, 17, -56, 9, 123, 104, 98, -28, -12 };

    static byte[] b = { -86, -68, -127, -24, 61, 119, -75, 89, -118, 62 };

    static long[] c = { -9223372036854775808L, 0, 5196348007264225459L, 0, 0, -7607919486297307059L, 9223372036854775807L, -4123563020004464869L, 0, 0 };

    static long[] d = { -9223372036854775808L, -2636098918725204463L, 9223372036854775807L, -9223372036854775808L, -9223372036854775808L, -9223372036854775808L, -8900629418400505434L, 9223372036854775807L, 9223372036854775807L, -9223372036854775808L };

    byte[] test_cp_neg(byte[] a, byte[] b, long[] c, long[] d) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = b[i];
            c[i] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7653().test_cp_neg(a, b, c, d);
    }
}
