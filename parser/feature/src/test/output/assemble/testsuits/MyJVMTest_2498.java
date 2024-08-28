public class MyJVMTest_2498 {

    static char[] a0 = { '0', Character.MIN_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, '0', '6', 'a', Character.MIN_VALUE, Character.MAX_VALUE, '0' };

    static char[] a1 = { 'x', Character.MAX_VALUE, Character.MAX_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, Character.MAX_VALUE };

    static int SHIFT = 16;

    char[] test_srac_o(char[] a0, char[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (char) (a1[i] >> SHIFT);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2498().test_srac_o(a0, a1);
    }
}
