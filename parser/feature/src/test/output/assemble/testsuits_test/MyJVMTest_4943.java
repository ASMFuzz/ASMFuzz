public class MyJVMTest_4943 {

    static char[] a0 = { '@', Character.MAX_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, '.', Character.MAX_VALUE, Character.MAX_VALUE, '^', '0', '!' };

    static char[] a1 = { Character.MIN_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, Character.MIN_VALUE, '!', Character.MAX_VALUE, 'd', Character.MIN_VALUE, Character.MIN_VALUE, Character.MIN_VALUE };

    static int b = 0;

    char[] test_sllv(char[] a0, char[] a1, int b) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (char) (a1[i] << b);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4943().test_sllv(a0, a1, b);
    }
}
