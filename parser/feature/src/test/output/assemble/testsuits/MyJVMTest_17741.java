public class MyJVMTest_17741 {

    static long[] a = { 0, -3320189183576971049L, -9223372036854775808L, -9223372036854775808L, -9223372036854775808L, -9131484549916410354L, -9223372036854775808L, -9223372036854775808L, 9223372036854775807L, 9223372036854775807L };

    long[] test_ci_neg(long[] a) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = -123;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17741().test_ci_neg(a);
    }
}
