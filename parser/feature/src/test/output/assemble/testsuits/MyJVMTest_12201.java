public class MyJVMTest_12201 {

    static long[] p2 = { 0, 6493645568386386234L, 0, 0, -1892994244016543560L, -9223372036854775808L, 9223372036854775807L, 0, -5118892155337781855L, 9223372036854775807L };

    static int[] a1 = { 7, 5, 2, 8, 0, 858440073, 6, 2, 9, 7 };

    long[] test_pack2_swap(long[] p2, int[] a1) {
        if (p2.length * 2 > a1.length)
            return;
        for (int i = 0; i < p2.length; i += 1) {
            long l0 = (long) a1[i * 2 + 0];
            long l1 = (long) a1[i * 2 + 1];
            p2[i] = (l0 << 32) | (l1 & 0xFFFFFFFFl);
        }
        return p2;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12201().test_pack2_swap(p2, a1);
    }
}
