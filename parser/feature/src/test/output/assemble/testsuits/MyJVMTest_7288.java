public class MyJVMTest_7288 {

    static long[] dst = { 5123536801905860815L, -9223372036854775808L, -4461915590625354418L, -6361973684453666647L, 9223372036854775807L, -9223372036854775808L, 0, 0, 0, 2362027267565401378L };

    static long[] src = { 9223372036854775807L, 0, 9223372036854775807L, 799577533298571077L, -5416648714833267151L, -3479039536611156258L, 0, 0, 0, -9223372036854775808L };

    static long _l = 0L;

    long[] test_copy_longs_store_reversed(long[] dst, long[] src) {
        for (int i = 0; i < src.length; i++) {
            dst[i] = Long.reverseBytes(1 + src[i]);
        }
        return src;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7288().test_copy_longs_store_reversed(dst, src);
    }
}
