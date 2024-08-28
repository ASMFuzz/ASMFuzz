public class MyJVMTest_11613 {

    static int[] a0 = { 0, 0, 0, 0, 9, 0, 0, 0, 0, 8 };

    static long[] p2 = { -9223372036854775808L, -9223372036854775808L, 0, 0, 0, 0, 9223372036854775807L, 5542684932315639227L, -9223372036854775808L, 9223372036854775807L };

    int[] test_unpack2_swap(int[] a0, long[] p2) {
        if (p2.length * 2 > a0.length)
            return;
        for (int i = 0; i < p2.length; i += 1) {
            long l = p2[i];
            a0[i * 2 + 0] = (int) (l >> 32);
            a0[i * 2 + 1] = (int) (l & 0xFFFFFFFFl);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11613().test_unpack2_swap(a0, p2);
    }
}
