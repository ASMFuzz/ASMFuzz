public class MyJVMTest_11669 {

    static char[] a0 = { Character.MAX_VALUE, Character.MIN_VALUE, 'G', Character.MAX_VALUE, Character.MAX_VALUE, '0', Character.MAX_VALUE, '0', Character.MAX_VALUE, 'u' };

    static char[] a1 = { Character.MIN_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, ']', '0', 'A', 'D', '0', '+', 'c' };

    static int VALUE = 7;

    char[] test_srac_n(char[] a0, char[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (char) (a1[i] >> (-VALUE));
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11669().test_srac_n(a0, a1);
    }
}
