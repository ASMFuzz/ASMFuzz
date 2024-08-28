public class MyJVMTest_11149 {

    static char[] a0 = { Character.MAX_VALUE, Character.MAX_VALUE, '9', Character.MAX_VALUE, '+', '0', 'L', '9', '0', '0' };

    static char[] a1 = { '0', Character.MIN_VALUE, '0', '0', '0', 'F', '&', Character.MIN_VALUE, Character.MIN_VALUE, 'b' };

    static int BIT_MASK = 0xB731;

    static int VALUE = 7;

    char[] test_srac_and(char[] a0, char[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (char) ((a1[i] & BIT_MASK) >> VALUE);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11149().test_srac_and(a0, a1);
    }
}
