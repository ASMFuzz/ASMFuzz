public class MyJVMTest_10849 {

    static short[] a = { 0, -12863, 4619, 0, 0, 0, 0, -10928, -32768, 0 };

    static long[] b = { 0, 9223372036854775807L, -4491042077297060965L, -9223372036854775808L, -9223372036854775808L, -9223372036854775808L, -9223372036854775808L, 0, 9223372036854775807L, 9223372036854775807L };

    static short c = 0;

    static long d = 9223372036854775807L;

    short[] test_vi_neg(short[] a, long[] b, short c, long d) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = c;
            b[i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10849().test_vi_neg(a, b, c, d);
    }
}
