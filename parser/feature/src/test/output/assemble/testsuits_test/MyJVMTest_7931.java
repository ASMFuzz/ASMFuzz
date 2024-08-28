public class MyJVMTest_7931 {

    static long[] dst = { 9223372036854775807L, 9223372036854775807L, -954743949436149558L, -9223372036854775808L, 0, -15732752418726142L, 0, 0, -1371602757414568720L, -9223372036854775808L };

    static long[] src = { 9223372036854775807L, -9223372036854775808L, 0, 0, 9223372036854775807L, 0, 9223372036854775807L, -9223372036854775808L, 0, -9223372036854775808L };

    static long _l = 0L;

    long[] test_copy_longs_reversed(long[] dst, long[] src) {
        for (int i = 0; i < src.length; i++) {
            dst[i] = 1 + Long.reverseBytes(src[i]);
        }
        return src;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7931().test_copy_longs_reversed(dst, src);
    }
}
