public class MyJVMTest_11839 {

    static long[] a = { -1490073382825289166L, -3809786615587276748L, -9223372036854775808L, 0, -9223372036854775808L, 6203788899481917703L, 0, 0, 0, -9223372036854775808L };

    static long[] b = { -9223372036854775808L, 9223372036854775807L, 0, -9223372036854775808L, -9223372036854775808L, -9223372036854775808L, 0, 0, 9223372036854775807L, 9223372036854775807L };

    static int OFFSET = 3;

    long[] test_cp_off(long[] a, long[] b) {
        for (int i = 0; i < a.length - OFFSET; i += 1) {
            a[i + OFFSET] = b[i + OFFSET];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11839().test_cp_off(a, b);
    }
}
