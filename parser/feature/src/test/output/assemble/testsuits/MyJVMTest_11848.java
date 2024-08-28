public class MyJVMTest_11848 {

    static char[] a0 = { Character.MAX_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, 'G', Character.MIN_VALUE, Character.MAX_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, Character.MAX_VALUE };

    static char[] a1 = { Character.MAX_VALUE, Character.MAX_VALUE, '0', 'm', 'D', Character.MIN_VALUE, Character.MIN_VALUE, '*', Character.MAX_VALUE, Character.MIN_VALUE };

    static int SHIFT = 16;

    char[] test_sllc_o(char[] a0, char[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (char) (a1[i] << SHIFT);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11848().test_sllc_o(a0, a1);
    }
}
