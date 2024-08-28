public class MyJVMTest_6734 {

    static byte[] a = { 82, -7, 15, -77, -118, -95, 99, -102, -36, -33 };

    static long[] b = { -7948821713657513789L, 0, -9223372036854775808L, 0, 8305136651597726675L, 0, -9223372036854775808L, 1471080632681873267L, 9223372036854775807L, -4660439482232267203L };

    static byte c = 127;

    static long d = 9223372036854775807L;

    byte[] test_vi_neg(byte[] a, long[] b, byte c, long d) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = c;
            b[i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6734().test_vi_neg(a, b, c, d);
    }
}
