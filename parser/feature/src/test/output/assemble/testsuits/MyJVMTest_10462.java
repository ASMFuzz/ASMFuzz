public class MyJVMTest_10462 {

    static char[] a0 = { '0', Character.MAX_VALUE, Character.MAX_VALUE, '@', 'F', Character.MIN_VALUE, Character.MAX_VALUE, '0', 'X', '?' };

    static char[] a1 = { '0', 'I', 'u', Character.MAX_VALUE, Character.MAX_VALUE, '_', Character.MIN_VALUE, Character.MIN_VALUE, '0', '0' };

    static int SHIFT = 16;

    char[] test_srlc_o(char[] a0, char[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (char) (a1[i] >>> SHIFT);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10462().test_srlc_o(a0, a1);
    }
}
