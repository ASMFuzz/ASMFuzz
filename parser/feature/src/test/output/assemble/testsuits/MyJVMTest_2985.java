public class MyJVMTest_2985 {

    static char[] a0 = { '0', Character.MAX_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, '?', 'h', 'f', 'n', Character.MAX_VALUE, '0' };

    static char[] a1 = { Character.MIN_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, '0', '0', '0', '0', Character.MIN_VALUE };

    static int SHIFT = 16;

    char[] test_srlc_on(char[] a0, char[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (char) (a1[i] >>> (-SHIFT));
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2985().test_srlc_on(a0, a1);
    }
}
