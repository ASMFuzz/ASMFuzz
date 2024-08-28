public class MyJVMTest_16496 {

    static char[] a0 = { '&', Character.MIN_VALUE, Character.MIN_VALUE, '0', Character.MIN_VALUE, '!', Character.MIN_VALUE, Character.MAX_VALUE, Character.MIN_VALUE, '0' };

    static char[] a1 = { Character.MAX_VALUE, '0', '0', '0', Character.MIN_VALUE, '0', 'w', Character.MAX_VALUE, Character.MAX_VALUE, Character.MAX_VALUE };

    static int BIT_MASK = 0xB731;

    char[] test_xorc(char[] a0, char[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (char) (a1[i] ^ BIT_MASK);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16496().test_xorc(a0, a1);
    }
}
