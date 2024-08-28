public class MyJVMTest_5774 {

    static char[] a0 = { Character.MIN_VALUE, '0', Character.MIN_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, Character.MIN_VALUE, 'k', 'V', '<', '0' };

    static char[] a1 = { 'X', Character.MIN_VALUE, Character.MAX_VALUE, 'a', Character.MIN_VALUE, 'H', '0', '0', Character.MIN_VALUE, '0' };

    static short[] a2 = { 0, -2584, -32768, -32768, -23372, 0, -32768, 32767, 0, 32767 };

    char[] test_suba(char[] a0, char[] a1, short[] a2) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (char) (a1[i] - a2[i]);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5774().test_suba(a0, a1, a2);
    }
}
