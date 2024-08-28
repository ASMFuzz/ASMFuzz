public class MyJVMTest_15870 {

    static short[] a = { 32767, -18575, -842, 32767, 0, 0, 32767, 0, -32768, -32768 };

    static short[] b = { 32767, 32767, 0, 0, 0, -32768, 0, 32767, 0, -32768 };

    static long[] c = { 9223372036854775807L, -9223372036854775808L, 0, -9223372036854775808L, 9223372036854775807L, 0, 0, -9223372036854775808L, 0, 0 };

    static long[] d = { -9223372036854775808L, -9223372036854775808L, 0, -1272749163990285725L, -9223372036854775808L, -9223372036854775808L, -9223372036854775808L, 6114139279677498742L, 9223372036854775807L, 9223372036854775807L };

    static int ALIGN_OFF = 8;

    short[] test_cp_alndst(short[] a, short[] b, long[] c, long[] d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i + ALIGN_OFF] = b[i];
            c[i + ALIGN_OFF] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15870().test_cp_alndst(a, b, c, d);
    }
}
