public class MyJVMTest_9555 {

    static long[] a = { -4517772371368973359L, -9223372036854775808L, 9223372036854775807L, 0, -9223372036854775808L, 0, 0, 5066124350555007685L, 8787475254072315389L, 9223372036854775807L };

    static long[] b = { 9223372036854775807L, 0, 5230808473475697146L, -9223372036854775808L, 0, -9134819823774391960L, 9223372036854775807L, -9223372036854775808L, 9223372036854775807L, -9223372036854775808L };

    static long c = 0;

    static long d = 0;

    long[] test_2vi_neg(long[] a, long[] b, long c, long d) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = c;
            b[i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9555().test_2vi_neg(a, b, c, d);
    }
}
