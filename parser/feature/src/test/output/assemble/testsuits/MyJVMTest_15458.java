public class MyJVMTest_15458 {

    static char[] a0 = { '0', Character.MAX_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, 'T', Character.MIN_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, '/', '0' };

    static char[] a1 = { '0', 'd', Character.MIN_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, Character.MIN_VALUE };

    static int BIT_MASK = 0xB731;

    static int VALUE = 7;

    char[] test_srlc_and(char[] a0, char[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (char) ((a1[i] & BIT_MASK) >>> VALUE);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15458().test_srlc_and(a0, a1);
    }
}
