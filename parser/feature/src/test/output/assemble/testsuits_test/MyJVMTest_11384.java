public class MyJVMTest_11384 {

    static long[] a = { 9223372036854775807L, -9223372036854775808L, -9223372036854775808L, -3173671026757164983L, 9223372036854775807L, -3647138145962157017L, 0, -9223372036854775808L, -9223372036854775808L, -2246227607960553516L };

    static long b = 286376978925387844L;

    int test_vi_oppos(long[] a, long b) {
        int limit = a.length - 1;
        for (int i = limit; i >= 0; i -= 1) {
            a[limit - i] = b;
        }
        return limit;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11384().test_vi_oppos(a, b);
    }
}
