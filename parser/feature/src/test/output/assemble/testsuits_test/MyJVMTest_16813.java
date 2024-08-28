public class MyJVMTest_16813 {

    static long[] dst = { 9223372036854775807L, -9223372036854775808L, 9223372036854775807L, 0, 0, -9223372036854775808L, -9223372036854775808L, -9223372036854775808L, -8500639162671033196L, -9194883263609379181L };

    static long[] src = { -4060151711044426989L, 9223372036854775807L, 0, 0, -1700822547370052003L, -9223372036854775808L, -6758042665593940922L, 9223372036854775807L, -9223372036854775808L, 9223372036854775807L };

    static long _l = 0L;

    long[] test_copy_longs_store_reversed(long[] dst, long[] src) {
        for (int i = 0; i < src.length; i++) {
            dst[i] = Long.reverseBytes(1 + src[i]);
        }
        return src;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16813().test_copy_longs_store_reversed(dst, src);
    }
}
