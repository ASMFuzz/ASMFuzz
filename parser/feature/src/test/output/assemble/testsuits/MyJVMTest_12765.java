public class MyJVMTest_12765 {

    static char[] a0 = { Character.MIN_VALUE, '_', Character.MIN_VALUE, Character.MIN_VALUE, '0', 'k', Character.MAX_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, Character.MIN_VALUE };

    static char[] a1 = { '1', Character.MIN_VALUE, 'd', ',', Character.MIN_VALUE, Character.MAX_VALUE, '@', Character.MAX_VALUE, 'L', '0' };

    static int ADD_INIT = Character.MAX_VALUE - 500;

    static int VALUE = 7;

    char[] test_sllc_add(char[] a0, char[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (char) ((a1[i] + ADD_INIT) << VALUE);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12765().test_sllc_add(a0, a1);
    }
}
