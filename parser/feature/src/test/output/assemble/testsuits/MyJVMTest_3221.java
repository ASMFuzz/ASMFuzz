public class MyJVMTest_3221 {

    static int[] a = { 0, 8, 1512141329, 0, 7, 0, 8, 782850225, -1835770738, 7 };

    static int[] b = { 4, -1396504308, -1642031839, 0, 2, 8, 2070616778, 6, 7, 2 };

    static long[] c = { 0, -9223372036854775808L, 9223372036854775807L, 0, 9223372036854775807L, 0, 6569017449951155635L, 9223372036854775807L, -9223372036854775808L, -2907573015854102709L };

    static long[] d = { 0, 0, 0, -9223372036854775808L, -9223372036854775808L, 9223372036854775807L, -9223372036854775808L, 0, 2125878545948231877L, -9223372036854775808L };

    static int ALIGN_OFF = 8;

    int[] test_cp_alnsrc(int[] a, int[] b, long[] c, long[] d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i] = b[i + ALIGN_OFF];
            c[i] = d[i + ALIGN_OFF];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3221().test_cp_alnsrc(a, b, c, d);
    }
}
