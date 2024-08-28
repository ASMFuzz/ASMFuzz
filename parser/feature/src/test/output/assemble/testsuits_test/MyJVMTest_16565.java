public class MyJVMTest_16565 {

    static char[] a0 = { Character.MAX_VALUE, Character.MIN_VALUE, '0', Character.MIN_VALUE, Character.MIN_VALUE, '0', '0', Character.MIN_VALUE, Character.MAX_VALUE, '>' };

    static char[] a1 = { 'w', Character.MIN_VALUE, 'X', Character.MIN_VALUE, 'O', Character.MIN_VALUE, 'c', 'H', '-', '0' };

    static int b = 0;

    static int VALUE = 7;

    char[] test_srlv_and(char[] a0, char[] a1, int b) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (char) ((a1[i] & b) >>> VALUE);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16565().test_srlv_and(a0, a1, b);
    }
}
