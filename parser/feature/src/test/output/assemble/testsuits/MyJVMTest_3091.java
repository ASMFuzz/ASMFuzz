public class MyJVMTest_3091 {

    static long[] p2 = { 9223372036854775807L, -9223372036854775808L, -9223372036854775808L, -4031133684346212968L, -6669005588816758788L, 0, 0, -5099225261825104348L, 0, 5124637892973125922L };

    static int[] a1 = { 7, -1795257330, 0, 6, 0, 9, 9, 2017188443, 0, -854531047 };

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
        new MyJVMTest_3091().test_pack2(p2, a1);
    }
}
