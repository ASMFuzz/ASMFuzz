public class MyJVMTest_2902 {

    static long[] p2 = { 9223372036854775807L, -3675860897229823577L, -9223372036854775808L, 0, -9223372036854775808L, -8427452171318665065L, 0, 0, 8533783107715849650L, -9223372036854775808L };

    static int[] a1 = { -1655154476, 5, -1372200259, 4, 8, 1, 8, 0, -2108021433, -1189544026 };

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
        new MyJVMTest_2902().test_pack2_swap(p2, a1);
    }
}
