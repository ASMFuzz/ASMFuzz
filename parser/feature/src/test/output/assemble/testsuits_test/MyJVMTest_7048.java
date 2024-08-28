public class MyJVMTest_7048 {

    static char[] a0 = { Character.MIN_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, '0', '0', '0', 'b', Character.MAX_VALUE, Character.MAX_VALUE, Character.MAX_VALUE };

    static char[] a1 = { '&', '*', Character.MIN_VALUE, Character.MAX_VALUE, '+', Character.MIN_VALUE, Character.MIN_VALUE, '0', Character.MIN_VALUE, Character.MAX_VALUE };

    static int b = 6;

    static int VALUE = 7;

    char[] test_srlv_and(char[] a0, char[] a1, int b) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (char) ((a1[i] & b) >>> VALUE);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7048().test_srlv_and(a0, a1, b);
    }
}
