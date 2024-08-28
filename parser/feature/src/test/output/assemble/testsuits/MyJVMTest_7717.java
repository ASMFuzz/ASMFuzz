public class MyJVMTest_7717 {

    static long[] a = { -1749922656640975592L, 9223372036854775807L, 737969653491532403L, -9223372036854775808L, 9223372036854775807L, 0, 9223372036854775807L, 0, -9223372036854775808L, 9223372036854775807L };

    static long[] b = { -3253097947551532688L, 0, 9223372036854775807L, 0, -9223372036854775808L, 0, -9223372036854775808L, 0, -9223372036854775808L, 9223372036854775807L };

    static long c = 0;

    static long d = 0;

    long[] test_2vi(long[] a, long[] b, long c, long d) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = c;
            b[i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7717().test_2vi(a, b, c, d);
    }
}
