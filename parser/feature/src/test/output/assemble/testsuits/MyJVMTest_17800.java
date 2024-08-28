public class MyJVMTest_17800 {

    static int[] a0 = { 5, 3, 2, 7, -1382091468, 1, 0, -1999837998, 4, 0 };

    static long[] p2 = { 9223372036854775807L, 9223372036854775807L, 9223372036854775807L, -7845164083520222578L, 9223372036854775807L, -9223372036854775808L, -9223372036854775808L, 0, -9223372036854775808L, 0 };

    int[] test_unpack2(int[] a0, long[] p2) {
        if (p2.length * 2 > a0.length)
            return;
        for (int i = 0; i < p2.length; i += 1) {
            long l = p2[i];
            a0[i * 2 + 0] = (int) (l & 0xFFFFFFFFl);
            a0[i * 2 + 1] = (int) (l >> 32);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17800().test_unpack2(a0, p2);
    }
}
