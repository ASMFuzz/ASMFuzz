public class MyJVMTest_11127 {

    static long[] a = { -9223372036854775808L, 0, 0, 977923312612645061L, -9223372036854775808L, 0, 0, -9223372036854775808L, 9223372036854775807L, 0 };

    static long[] b = { 9223372036854775807L, 0, -2549466899552132355L, -9223372036854775808L, 9223372036854775807L, 7727144205470005024L, -6083522197764236054L, 4711494340730167381L, -2066063131472158294L, 9223372036854775807L };

    static long c = -9223372036854775808L;

    static long d = 0;

    static int SCALE = 2;

    long[] test_2vi_scl(long[] a, long[] b, long c, long d) {
        for (int i = 0; i * SCALE < a.length; i += 1) {
            a[i * SCALE] = c;
            b[i * SCALE] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11127().test_2vi_scl(a, b, c, d);
    }
}
