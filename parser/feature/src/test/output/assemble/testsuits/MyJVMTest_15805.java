public class MyJVMTest_15805 {

    static short[] a = { -32768, 32767, 32594, -27680, -2414, 32767, 10173, -32768, 30904, 32767 };

    static short[] b = { 32767, -32768, 32767, 32767, 0, -32768, -32768, -8747, 32767, -32768 };

    static long[] c = { -9223372036854775808L, 9223372036854775807L, -4556572860866604822L, -9223372036854775808L, 3509183463706429780L, -9223372036854775808L, -8662507001309131761L, 9223372036854775807L, 9223372036854775807L, 0 };

    static long[] d = { 805614745422361190L, 8517601653136128924L, 3388782515455086108L, 9223372036854775807L, -9223372036854775808L, 0, -9223372036854775808L, 9223372036854775807L, 0, -659799146090965878L };

    short[] test_cp_oppos(short[] a, short[] b, long[] c, long[] d) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b[limit - i];
            c[limit - i] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15805().test_cp_oppos(a, b, c, d);
    }
}
