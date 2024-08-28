public class MyJVMTest_11811 {

    static short[] a = { -30668, 0, 0, 0, 32767, -32768, -32768, 0, -2458, 32767 };

    static long[] b = { -7015781405756461031L, 6922585711710604317L, 0, 9223372036854775807L, 9223372036854775807L, -9223372036854775808L, -3121590633543800047L, 1140421622445269422L, 0, 0 };

    short[] test_ci_oppos(short[] a, long[] b) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[limit - i] = -123;
            b[i] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11811().test_ci_oppos(a, b);
    }
}
