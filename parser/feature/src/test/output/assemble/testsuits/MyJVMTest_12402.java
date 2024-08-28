public class MyJVMTest_12402 {

    static long[] p2 = { 0, -9223372036854775808L, -9223372036854775808L, 5984156154626081114L, -9223372036854775808L, 9223372036854775807L, -9223372036854775808L, -9223372036854775808L, 0, 9223372036854775807L };

    static int[] a1 = { 0, 9, 0, 5, 0, 1, 310993440, 0, 0, 80645196 };

    long[] test_pack2(long[] p2, int[] a1) {
        if (p2.length * 2 > a1.length)
            return;
        for (int i = 0; i < p2.length; i += 1) {
            long l0 = (long) a1[i * 2 + 0];
            long l1 = (long) a1[i * 2 + 1];
            p2[i] = (l1 << 32) | (l0 & 0xFFFFFFFFl);
        }
        return p2;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12402().test_pack2(p2, a1);
    }
}
