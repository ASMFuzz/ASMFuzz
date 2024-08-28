public class MyJVMTest_1733 {

    static char[] a0 = { '0', Character.MAX_VALUE, Character.MAX_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, Character.MIN_VALUE, '0', '!', 'p', Character.MAX_VALUE };

    static char[] a1 = { '0', '0', Character.MIN_VALUE, 'T', '0', Character.MIN_VALUE, Character.MIN_VALUE, '0', Character.MAX_VALUE, Character.MAX_VALUE };

    static short b = 32767;

    char[] test_xorv(char[] a0, char[] a1, short b) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (char) (a1[i] ^ b);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1733().test_xorv(a0, a1, b);
    }
}
