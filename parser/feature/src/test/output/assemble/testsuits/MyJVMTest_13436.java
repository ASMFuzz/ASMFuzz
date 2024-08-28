public class MyJVMTest_13436 {

    static char[] a0 = { '0', Character.MIN_VALUE, 'p', Character.MAX_VALUE, Character.MAX_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, '{', '0', '0' };

    static char[] a1 = { '{', Character.MAX_VALUE, 'C', Character.MAX_VALUE, 's', '0', '0', Character.MIN_VALUE, Character.MAX_VALUE, Character.MIN_VALUE };

    static int ADD_INIT = Character.MAX_VALUE - 500;

    static int VALUE = 7;

    char[] test_srac_add(char[] a0, char[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (char) ((a1[i] + ADD_INIT) >> VALUE);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13436().test_srac_add(a0, a1);
    }
}
