public class MyJVMTest_1896 {

    static long[] a = { -9223372036854775808L, 9223372036854775807L, 9223372036854775807L, 1395456928863524648L, 9223372036854775807L, -9223372036854775808L, 6625678192097883041L, -9223372036854775808L, -9223372036854775808L, -9223372036854775808L };

    static long[] b = { 9223372036854775807L, -857924187768098050L, -9223372036854775808L, 0, -9223372036854775808L, 0, -5118340871397844963L, -9223372036854775808L, -9223372036854775808L, -9223372036854775808L };

    static long c = 0;

    static long d = -1953968584909436997L;

    static int SCALE = 2;

    long[] test_2vi_scl(long[] a, long[] b, long c, long d) {
        for (int i = 0; i * SCALE < a.length; i += 1) {
            a[i * SCALE] = c;
            b[i * SCALE] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1896().test_2vi_scl(a, b, c, d);
    }
}
