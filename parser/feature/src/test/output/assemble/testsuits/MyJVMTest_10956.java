public class MyJVMTest_10956 {

    static char[] a0 = { '0', Character.MAX_VALUE, Character.MAX_VALUE, 'r', '0', 'q', Character.MAX_VALUE, '0', '*', Character.MIN_VALUE };

    static char[] a1 = { Character.MIN_VALUE, 'c', '0', Character.MIN_VALUE, Character.MAX_VALUE, '[', Character.MIN_VALUE, '0', Character.MAX_VALUE, '0' };

    static short b = -32768;

    char[] test_xorv(char[] a0, char[] a1, short b) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (char) (a1[i] ^ b);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10956().test_xorv(a0, a1, b);
    }
}
