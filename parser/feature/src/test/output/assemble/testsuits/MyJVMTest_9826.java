public class MyJVMTest_9826 {

    static char[] a0 = { 'm', Character.MIN_VALUE, '7', '0', Character.MAX_VALUE, 'R', Character.MIN_VALUE, Character.MAX_VALUE, 'H', Character.MIN_VALUE };

    static char[] a1 = { Character.MAX_VALUE, 'h', Character.MIN_VALUE, Character.MAX_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, Character.MIN_VALUE, Character.MAX_VALUE };

    static int ADD_INIT = Character.MAX_VALUE - 500;

    static int VALUE = 7;

    char[] test_srlc_add(char[] a0, char[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (char) ((a1[i] + ADD_INIT) >>> VALUE);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9826().test_srlc_add(a0, a1);
    }
}
