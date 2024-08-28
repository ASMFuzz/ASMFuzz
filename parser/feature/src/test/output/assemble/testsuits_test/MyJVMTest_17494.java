public class MyJVMTest_17494 {

    static long[] dst = { -9223372036854775808L, 9223372036854775807L, -9223372036854775808L, 0, 0, 9223372036854775807L, 9223372036854775807L, -2006480701178183165L, -416016314182194929L, -9223372036854775808L };

    static long[] src = { 3365128526557921402L, 9223372036854775807L, 0, -5576109232677730771L, -1863750763922432902L, -8638040224621961674L, -9223372036854775808L, 0, 0, 0 };

    static long _l = 0L;

    long[] test_copy_longs_reversed(long[] dst, long[] src) {
        for (int i = 0; i < src.length; i++) {
            dst[i] = 1 + Long.reverseBytes(src[i]);
        }
        return src;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17494().test_copy_longs_reversed(dst, src);
    }
}
