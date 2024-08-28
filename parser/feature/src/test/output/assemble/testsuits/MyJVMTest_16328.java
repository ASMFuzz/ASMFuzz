public class MyJVMTest_16328 {

    static char[] a0 = { Character.MAX_VALUE, 'D', Character.MAX_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, Character.MIN_VALUE, 'v', '0', Character.MAX_VALUE, Character.MAX_VALUE };

    static int[] p2 = { 0, 8, 5, 0, 3, 1285130510, 0, 0, 4, -1000509634 };

    char[] test_unpack2(char[] a0, int[] p2) {
        if (p2.length * 2 > a0.length)
            return;
        for (int i = 0; i < p2.length; i += 1) {
            int l = p2[i];
            a0[i * 2 + 0] = (char) (l & 0xFFFF);
            a0[i * 2 + 1] = (char) (l >> 16);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16328().test_unpack2(a0, p2);
    }
}
