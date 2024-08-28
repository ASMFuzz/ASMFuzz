public class MyJVMTest_14724 {

    static char[] a0 = { ':', Character.MAX_VALUE, '0', '9', Character.MIN_VALUE, '0', Character.MAX_VALUE, 'V', Character.MAX_VALUE, Character.MAX_VALUE };

    static char[] a1 = { Character.MIN_VALUE, '0', Character.MAX_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, Character.MIN_VALUE, '.', ',', Character.MAX_VALUE, Character.MAX_VALUE };

    static int BIT_MASK = 0xB731;

    static int VALUE = 7;

    char[] test_sllc_and(char[] a0, char[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (char) ((a1[i] & BIT_MASK) << VALUE);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14724().test_sllc_and(a0, a1);
    }
}
