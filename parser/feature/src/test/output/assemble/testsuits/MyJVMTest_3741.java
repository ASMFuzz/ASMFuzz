public class MyJVMTest_3741 {

    static char[] a0 = { Character.MAX_VALUE, '0', '0', '0', '0', Character.MIN_VALUE, Character.MAX_VALUE, Character.MIN_VALUE, 'N', '0' };

    static char[] a1 = { 'm', Character.MAX_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, '!', Character.MAX_VALUE, 'J' };

    static int b = 0;

    static int VALUE = 7;

    char[] test_srlv_add(char[] a0, char[] a1, int b) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (char) ((a1[i] + b) >>> VALUE);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3741().test_srlv_add(a0, a1, b);
    }
}
