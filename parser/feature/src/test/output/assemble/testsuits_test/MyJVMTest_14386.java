public class MyJVMTest_14386 {

    static long[] dst = { -5817723681784298339L, -3661996312522993958L, -9223372036854775808L, -110343001000515803L, -9223372036854775808L, 9223372036854775807L, -4197807435410954324L, 9223372036854775807L, 7585749952828465553L, 8218958207717793746L };

    static long[] src = { 9223372036854775807L, 0, 9223372036854775807L, 0, -9223372036854775808L, -9223372036854775808L, 0, 0, -3853530382797114392L, 9223372036854775807L };

    static long _l = 0L;

    long[] test_copy_longs(long[] dst, long[] src) {
        for (int i = 0; i < src.length; i++) {
            dst[i] = Long.reverseBytes(src[i]);
        }
        return src;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14386().test_copy_longs(dst, src);
    }
}
