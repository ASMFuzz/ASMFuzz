public class MyJVMTest_14853 {

    static char[] a0 = { Character.MIN_VALUE, '0', Character.MIN_VALUE, '0', Character.MAX_VALUE, 'F', '0', Character.MAX_VALUE, Character.MIN_VALUE, Character.MIN_VALUE };

    static char[] a1 = { Character.MAX_VALUE, 'h', '0', 'j', Character.MAX_VALUE, '0', Character.MIN_VALUE, '0', Character.MIN_VALUE, Character.MAX_VALUE };

    static int b = -988704329;

    static int VALUE = 7;

    char[] test_sllv_add(char[] a0, char[] a1, int b) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (char) ((a1[i] + b) << VALUE);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14853().test_sllv_add(a0, a1, b);
    }
}
