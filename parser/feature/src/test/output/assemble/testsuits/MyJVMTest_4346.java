public class MyJVMTest_4346 {

    static long[] a = { 6117259907206732744L, 0, -8126538065023197929L, 9223372036854775807L, -9223372036854775808L, 9223372036854775807L, -9223372036854775808L, 2632522936132745982L, 0, -9223372036854775808L };

    static long[] b = { 9223372036854775807L, -9223372036854775808L, 0, 9223372036854775807L, -9223372036854775808L, -9223372036854775808L, 9223372036854775807L, 8542982592098863576L, -9223372036854775808L, -9223372036854775808L };

    long[] test_2ci_oppos(long[] a, long[] b) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[limit - i] = -123;
            b[i] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4346().test_2ci_oppos(a, b);
    }
}
