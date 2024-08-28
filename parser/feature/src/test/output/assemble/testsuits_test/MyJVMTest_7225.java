public class MyJVMTest_7225 {

    static int[] p2 = { 0, 0, 0, 7, 0, 6, 0, 0, 1, 148183344 };

    static char[] a1 = { Character.MAX_VALUE, 'i', 'D', 'E', '-', '/', '0', '0', '0', Character.MAX_VALUE };

    int[] test_pack2(int[] p2, char[] a1) {
        if (p2.length * 2 > a1.length)
            return;
        for (int i = 0; i < p2.length; i += 1) {
            int l0 = (int) a1[i * 2 + 0];
            int l1 = (int) a1[i * 2 + 1];
            p2[i] = (l1 << 16) | (l0 & 0xFFFF);
        }
        return p2;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7225().test_pack2(p2, a1);
    }
}
