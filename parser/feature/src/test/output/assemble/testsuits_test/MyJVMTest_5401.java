public class MyJVMTest_5401 {

    static int[] p2 = { 0, 0, -1307250356, 3, 1161867454, 0, 9, 0, 8, 0 };

    static char[] a1 = { Character.MAX_VALUE, Character.MIN_VALUE, 'q', '0', Character.MIN_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, '0', Character.MAX_VALUE, Character.MAX_VALUE };

    int[] test_pack2_swap(int[] p2, char[] a1) {
        if (p2.length * 2 > a1.length)
            return;
        for (int i = 0; i < p2.length; i += 1) {
            int l0 = (int) a1[i * 2 + 0];
            int l1 = (int) a1[i * 2 + 1];
            p2[i] = (l0 << 16) | (l1 & 0xFFFF);
        }
        return p2;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5401().test_pack2_swap(p2, a1);
    }
}
