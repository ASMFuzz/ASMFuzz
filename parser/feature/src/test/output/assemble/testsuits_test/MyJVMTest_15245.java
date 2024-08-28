public class MyJVMTest_15245 {

    static long[] a = { -5838886793286279184L, 9223372036854775807L, -6594877638626197686L, 9223372036854775807L, -9223372036854775808L, 9223372036854775807L, 2651012428575878391L, -9223372036854775808L, 0, -9223372036854775808L };

    static long[] b = { -9223372036854775808L, -9223372036854775808L, 0, 0, 0, 0, 9223372036854775807L, 9223372036854775807L, 9223372036854775807L, 7961369166053410121L };

    static long c = 9223372036854775807L;

    static long d = 9223372036854775807L;

    int test_2vi_oppos(long[] a, long[] b, long c, long d) {
        int limit = a.length - 1;
        for (int i = limit; i >= 0; i -= 1) {
            a[i] = c;
            b[limit - i] = d;
        }
        return limit;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15245().test_2vi_oppos(a, b, c, d);
    }
}
