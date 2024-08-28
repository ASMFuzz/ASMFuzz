public class MyJVMTest_11814 {

    static char[] a0 = { Character.MAX_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, 'H', Character.MIN_VALUE, '0', '-', Character.MIN_VALUE, Character.MAX_VALUE, Character.MAX_VALUE };

    static char[] a1 = { Character.MAX_VALUE, '0', Character.MIN_VALUE, '0', Character.MAX_VALUE, 'n', Character.MIN_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, Character.MAX_VALUE };

    static int SHIFT = 16;

    char[] test_sllc_on(char[] a0, char[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (char) (a1[i] << (-SHIFT));
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11814().test_sllc_on(a0, a1);
    }
}
