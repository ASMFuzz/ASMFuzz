public class MyJVMTest_15076 {

    static char[] a0 = { '0', '0', '@', 'N', Character.MIN_VALUE, 'B', Character.MIN_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, Character.MAX_VALUE };

    static int[] p2 = { 859208961, 0, 5, 8, -1619688320, 9, 5, 9, 6, 0 };

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
        new MyJVMTest_15076().test_unpack2_swap(a0, p2);
    }
}
