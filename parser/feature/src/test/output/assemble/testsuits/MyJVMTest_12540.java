public class MyJVMTest_12540 {

    static int[] a = { 2, 8, 3, 0, -133281994, 0, -903026348, 6, -1887017934, 0 };

    static int[] b = { 8, 0, 0, 529019632, 0, 0, 1576958680, 0, 7, 823164163 };

    static long[] c = { -8760029476595432353L, 0, -4896862555541364648L, 0, 0, -9223372036854775808L, 9223372036854775807L, 0, 9223372036854775807L, 9223372036854775807L };

    static long[] d = { 0, 9223372036854775807L, -7269568216712245780L, -2782183644997091550L, -9223372036854775808L, 0, 9223372036854775807L, -9223372036854775808L, 0, 9223372036854775807L };

    static int ALIGN_OFF = 8;

    int[] test_cp_alnsrc(int[] a, int[] b, long[] c, long[] d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i] = b[i + ALIGN_OFF];
            c[i] = d[i + ALIGN_OFF];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12540().test_cp_alnsrc(a, b, c, d);
    }
}
