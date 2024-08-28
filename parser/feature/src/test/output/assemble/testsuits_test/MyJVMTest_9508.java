public class MyJVMTest_9508 {

    static long[] a = { 9223372036854775807L, 2597407819698143695L, -2532368569269216567L, -3279686634244859754L, 0, 9223372036854775807L, 6143510224741906519L, 921628706324121212L, -9223372036854775808L, -9223372036854775808L };

    static long[] b = { -3412806697650045117L, 0, 0, -781895109879291754L, -5302252812898066118L, -9223372036854775808L, -9223372036854775808L, 9223372036854775807L, 0, -9088360726905899292L };

    static long c = -9223372036854775808L;

    static long d = 9223372036854775807L;

    static int OFFSET = 3;

    long[] test_2vi_off(long[] a, long[] b, long c, long d) {
        for (int i = 0; i < a.length - OFFSET; i += 1) {
            a[i + OFFSET] = c;
            b[i + OFFSET] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9508().test_2vi_off(a, b, c, d);
    }
}
