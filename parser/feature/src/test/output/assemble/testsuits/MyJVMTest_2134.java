public class MyJVMTest_2134 {

    static long[] a = { 2984712230471903778L, -8017066924540498625L, 9223372036854775807L, -9223372036854775808L, 0, -9223372036854775808L, -9223372036854775808L, 9223372036854775807L, -8180129730913171305L, -8674295713949206103L };

    static long b = 9223372036854775807L;

    int test_vi_oppos(long[] a, long b) {
        int limit = a.length - 1;
        for (int i = limit; i >= 0; i -= 1) {
            a[limit - i] = b;
        }
        return limit;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2134().test_vi_oppos(a, b);
    }
}
