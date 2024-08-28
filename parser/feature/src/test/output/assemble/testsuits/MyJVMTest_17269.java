public class MyJVMTest_17269 {

    static long[] a = { 1014101603258446524L, -9223372036854775808L, 9223372036854775807L, -2682075738605931054L, 9223372036854775807L, 0, 9223372036854775807L, 0, 0, 9223372036854775807L };

    static long[] b = { 3808453736752844609L, 9223372036854775807L, -382970214171269970L, -9223372036854775808L, 9223372036854775807L, -787070548498118415L, 0, 0, 9223372036854775807L, -9223372036854775808L };

    static long c = 9223372036854775807L;

    static long d = 9223372036854775807L;

    long[] test_2vi(long[] a, long[] b, long c, long d) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = c;
            b[i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17269().test_2vi(a, b, c, d);
    }
}
