public class MyJVMTest_16895 {

    static char[] a0 = { Character.MIN_VALUE, 'J', Character.MAX_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, Character.MIN_VALUE, 'f' };

    static char[] a1 = { '0', Character.MAX_VALUE, '%', 'q', '0', Character.MIN_VALUE, '\\', '0', Character.MIN_VALUE, 'p' };

    static int VALUE = 7;

    char[] test_srlc(char[] a0, char[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (char) (a1[i] >>> VALUE);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16895().test_srlc(a0, a1);
    }
}
