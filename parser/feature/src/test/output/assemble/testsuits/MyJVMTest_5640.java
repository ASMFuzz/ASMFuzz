public class MyJVMTest_5640 {

    static char[] a0 = { Character.MIN_VALUE, '\'', '0', '0', '0', Character.MIN_VALUE, Character.MIN_VALUE, '0', '-', Character.MIN_VALUE };

    static int[] p2 = { 0, 0, -610372871, 1652544100, 8, 1, 1743225779, 0, 0, 941458319 };

    char[] test_unpack2_swap(char[] a0, int[] p2) {
        if (p2.length * 2 > a0.length)
            return;
        for (int i = 0; i < p2.length; i += 1) {
            int l = p2[i];
            a0[i * 2 + 0] = (char) (l >> 16);
            a0[i * 2 + 1] = (char) (l & 0xFFFF);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5640().test_unpack2_swap(a0, p2);
    }
}
