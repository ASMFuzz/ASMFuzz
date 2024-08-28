public class MyJVMTest_14293 {

    static byte[] a = { -56, 116, -36, -120, -100, -76, -92, -3, 18, -23 };

    static byte[] b = { -85, -1, -9, -123, -119, 78, 54, 75, -84, 21 };

    static long[] c = { 9223372036854775807L, 9223372036854775807L, 0, 0, 9223372036854775807L, -8747521175871723452L, 9223372036854775807L, 0, 0, -3658852414362285506L };

    static long[] d = { -4214643968026389220L, 0, -9223372036854775808L, 9223372036854775807L, 0, 9223372036854775807L, 9223372036854775807L, 9223372036854775807L, 0, -9223372036854775808L };

    byte[] test_cp_oppos(byte[] a, byte[] b, long[] c, long[] d) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b[limit - i];
            c[limit - i] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14293().test_cp_oppos(a, b, c, d);
    }
}
