public class MyJVMTest_17075 {

    static byte[] a = { -16, -77, -4, -55, -78, 87, 10, 15, 100, 67 };

    static long[] b = { 9223372036854775807L, 9223372036854775807L, 9223372036854775807L, -9223372036854775808L, -8402365372097440644L, 1502738824479131002L, 0, -2359068468917614918L, -9223372036854775808L, 0 };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    byte[] test_ci_unaln(byte[] a, long[] b) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i + UNALIGN_OFF] = -123;
            b[i] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17075().test_ci_unaln(a, b);
    }
}
