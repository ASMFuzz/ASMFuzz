public class MyJVMTest_17202 {

    static byte[] a = { 78, 68, -13, 2, 59, 65, -54, 28, 21, 74 };

    static byte[] b = { -128, 17, 73, -71, 22, 53, 84, 60, 11, 25 };

    static long[] c = { 9223372036854775807L, -9223372036854775808L, -9223372036854775808L, 0, -9223372036854775808L, 9223372036854775807L, 9223372036854775807L, -9223372036854775808L, -9223372036854775808L, 9223372036854775807L };

    static long[] d = { -6312014832731903203L, 0, 0, 925797960261262808L, -9223372036854775808L, -9223372036854775808L, -9223372036854775808L, -8550276909904835846L, 0, 0 };

    byte[] test_cp_neg(byte[] a, byte[] b, long[] c, long[] d) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = b[i];
            c[i] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17202().test_cp_neg(a, b, c, d);
    }
}
