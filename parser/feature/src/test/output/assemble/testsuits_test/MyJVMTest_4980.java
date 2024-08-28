public class MyJVMTest_4980 {

    static long[] dst = { 9223372036854775807L, -4675891272688000964L, 1754228998474739727L, -9223372036854775808L, 3735569093275137129L, -4049286927803076860L, 0, 9223372036854775807L, 919368437279920644L, 0 };

    static long[] src = { -9223372036854775808L, -9223372036854775808L, 9223372036854775807L, 7204735170971082346L, -7062136800151624478L, 9223372036854775807L, 9223372036854775807L, -9223372036854775808L, 9223372036854775807L, 0 };

    static long _l = 0L;

    long[] test_copy_longs(long[] dst, long[] src) {
        for (int i = 0; i < src.length; i++) {
            dst[i] = Long.reverseBytes(src[i]);
        }
        return src;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4980().test_copy_longs(dst, src);
    }
}
