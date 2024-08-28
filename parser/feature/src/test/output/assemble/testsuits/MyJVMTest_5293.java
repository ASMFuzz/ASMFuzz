public class MyJVMTest_5293 {

    static short[] a = { 0, 0, -32768, 32767, 32767, 32767, 32767, 30835, 0, 32767 };

    static short[] b = { 0, 0, -32768, 32767, -32768, -32768, 0, 0, -32768, 32767 };

    static long[] c = { -9223372036854775808L, 0, 0, 7128718670734524126L, 9223372036854775807L, 9223372036854775807L, 0, -9223372036854775808L, 9223372036854775807L, 0 };

    static long[] d = { 0, 9223372036854775807L, -9223372036854775808L, 0, -1683077890235401282L, 0, 5387244209318693549L, 0, -9223372036854775808L, -9223372036854775808L };

    short[] test_cp_neg(short[] a, short[] b, long[] c, long[] d) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = b[i];
            c[i] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5293().test_cp_neg(a, b, c, d);
    }
}
