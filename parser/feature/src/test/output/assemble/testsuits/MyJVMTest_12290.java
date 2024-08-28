public class MyJVMTest_12290 {

    static char[] a0 = { Character.MIN_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, 'Q', '0', Character.MAX_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, Character.MIN_VALUE };

    static char[] a1 = { '0', '@', '0', 'W', Character.MIN_VALUE, 'A', Character.MIN_VALUE, '%', '0', Character.MIN_VALUE };

    static int SHIFT = 16;

    char[] test_srlc_on(char[] a0, char[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (char) (a1[i] >>> (-SHIFT));
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12290().test_srlc_on(a0, a1);
    }
}
