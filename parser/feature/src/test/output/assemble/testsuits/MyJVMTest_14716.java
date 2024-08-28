public class MyJVMTest_14716 {

    static short[] a = { 6827, 32767, -19757, 0, -32768, 32767, -32768, 7911, 0, -14480 };

    static short[] b = { 32767, 32767, 32767, -32768, -17304, 32767, -32768, 32767, 32767, 32767 };

    static long[] c = { 0, -39425654773087186L, 0, -6818199607644097076L, 0, -4262606478378177201L, -9223372036854775808L, 0, 0, 5098034534594123814L };

    static long[] d = { 0, 0, -9223372036854775808L, -9223372036854775808L, -9223372036854775808L, 9223372036854775807L, 9223372036854775807L, 9223372036854775807L, 0, 0 };

    short[] test_cp_neg(short[] a, short[] b, long[] c, long[] d) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = b[i];
            c[i] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14716().test_cp_neg(a, b, c, d);
    }
}
