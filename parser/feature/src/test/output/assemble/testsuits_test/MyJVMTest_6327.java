public class MyJVMTest_6327 {

    static short[] a = { 0, -32768, 0, 0, -32768, 25839, -32768, 30903, 32767, -32768 };

    static short[] b = { 0, -28741, -32768, 0, 24070, 7978, 0, -32768, -32768, 0 };

    static long[] c = { -9223372036854775808L, -9223372036854775808L, 0, 0, 5743154362606708953L, -9223372036854775808L, 0, -9223372036854775808L, 0, 910026033914101418L };

    static long[] d = { 0, -9223372036854775808L, 1181721299123041718L, 0, 9223372036854775807L, -9223372036854775808L, 1039988126938005884L, 0, 9223372036854775807L, 9223372036854775807L };

    short[] test_cp_oppos(short[] a, short[] b, long[] c, long[] d) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b[limit - i];
            c[limit - i] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6327().test_cp_oppos(a, b, c, d);
    }
}
