public class MyJVMTest_14073 {

    static char[] a0 = { '0', Character.MIN_VALUE, 'I', '0', 'h', Character.MIN_VALUE, Character.MIN_VALUE, '0', Character.MAX_VALUE, '0' };

    static char[] a1 = { '9', 'F', '0', '5', Character.MAX_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, Character.MIN_VALUE, 'n', Character.MIN_VALUE };

    static int VALUE = 7;

    char[] test_divc(char[] a0, char[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (char) (a1[i] / VALUE);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14073().test_divc(a0, a1);
    }
}
