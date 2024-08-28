public class MyJVMTest_4723 {

    static char[] a0 = { Character.MIN_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, Character.MIN_VALUE, '0', Character.MIN_VALUE, Character.MAX_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, '0' };

    static char[] a1 = { '0', 'N', Character.MIN_VALUE, '4', Character.MIN_VALUE, Character.MIN_VALUE, '0', Character.MAX_VALUE, '0', Character.MAX_VALUE };

    static int b = 1;

    static int VALUE = 7;

    char[] test_sllv_and(char[] a0, char[] a1, int b) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (char) ((a1[i] & b) << VALUE);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4723().test_sllv_and(a0, a1, b);
    }
}
