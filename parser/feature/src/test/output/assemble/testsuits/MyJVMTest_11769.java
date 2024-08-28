public class MyJVMTest_11769 {

    static char[] a0 = { Character.MIN_VALUE, Character.MAX_VALUE, '0', Character.MAX_VALUE, '@', Character.MAX_VALUE, Character.MIN_VALUE, '_', '0', 'G' };

    static char[] a1 = { '0', Character.MAX_VALUE, 'a', Character.MIN_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, '*', '0', 't', Character.MAX_VALUE };

    static int SHIFT = 16;

    char[] test_srac_o(char[] a0, char[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (char) (a1[i] >> SHIFT);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11769().test_srac_o(a0, a1);
    }
}
