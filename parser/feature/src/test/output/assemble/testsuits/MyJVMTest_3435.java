public class MyJVMTest_3435 {

    static char[] a0 = { Character.MIN_VALUE, Character.MAX_VALUE, 'Z', Character.MAX_VALUE, Character.MAX_VALUE, '0', 'S', 'H', '0', Character.MIN_VALUE };

    static char[] a1 = { 'i', Character.MAX_VALUE, 'K', Character.MIN_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, '}', Character.MIN_VALUE, Character.MIN_VALUE, Character.MIN_VALUE };

    static int ADD_INIT = Character.MAX_VALUE - 500;

    static int VALUE = 7;

    char[] test_sllc_add(char[] a0, char[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (char) ((a1[i] + ADD_INIT) << VALUE);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3435().test_sllc_add(a0, a1);
    }
}
