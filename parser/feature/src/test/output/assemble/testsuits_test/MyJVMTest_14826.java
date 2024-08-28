public class MyJVMTest_14826 {

    static int[] p2 = { 2, 7, 0, 2, 5, 4, 943811468, 0, 6, 2 };

    static char[] a1 = { Character.MIN_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, 'A', 'o', '0', 'K', 'R', Character.MIN_VALUE, Character.MAX_VALUE };

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
        new MyJVMTest_14826().test_pack2_swap(p2, a1);
    }
}
