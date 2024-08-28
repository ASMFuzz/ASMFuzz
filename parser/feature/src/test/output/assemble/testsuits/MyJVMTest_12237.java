public class MyJVMTest_12237 {

    static byte[] barray1 = { -56, -90, 115, 110, 98, 29, 42, 80, -119, 16 };

    static byte[] barray2 = { 4, -47, 41, 14, 27, 21, 73, 34, -67, -31 };

    static byte[] barray3 = { 95, 103, 72, -5, 89, -27, -90, -99, 97, 88 };

    static long[] larray = { 9223372036854775807L, 9223372036854775807L, 0, 9223372036854775807L, 9223372036854775807L, 9049141177124202722L, 9223372036854775807L, -9223372036854775808L, 9223372036854775807L, 0 };

    static long v = 9223372036854775807L;

    long[] test1(byte[] barray1, byte[] barray2, byte[] barray3, long[] larray, long v) {
        for (int i = 0; i < larray.length; i++) {
            larray[i] = v;
        }
        for (int i = 0; i < barray3.length; i++) {
            barray3[i] = (byte) (barray1[i] + barray2[i]);
        }
        return larray;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12237().test1(barray1, barray2, barray3, larray, v);
    }
}
