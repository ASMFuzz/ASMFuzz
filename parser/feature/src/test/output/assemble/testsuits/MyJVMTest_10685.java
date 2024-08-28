public class MyJVMTest_10685 {

    static char[] a0 = { Character.MAX_VALUE, Character.MIN_VALUE, '0', '0', Character.MAX_VALUE, '0', 'z', 'o', '0', Character.MIN_VALUE };

    static char[] a1 = { '0', Character.MAX_VALUE, 'u', Character.MAX_VALUE, 'M', Character.MAX_VALUE, Character.MAX_VALUE, 'g', Character.MIN_VALUE, 'f' };

    static short[] a2 = { 32767, 21626, 32767, 22573, 32767, -32768, 0, 0, 0, 26904 };

    char[] test_xora(char[] a0, char[] a1, short[] a2) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (char) (a1[i] ^ a2[i]);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10685().test_xora(a0, a1, a2);
    }
}
