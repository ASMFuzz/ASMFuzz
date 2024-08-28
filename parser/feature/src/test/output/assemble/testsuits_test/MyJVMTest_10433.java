public class MyJVMTest_10433 {

    static char[] a0 = { 'Z', Character.MIN_VALUE, '*', '0', Character.MAX_VALUE, '>', '0', '0', 'O', Character.MAX_VALUE };

    static char[] a1 = { Character.MIN_VALUE, Character.MIN_VALUE, '0', Character.MAX_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, '4', ']', Character.MIN_VALUE };

    static int b = 0;

    char[] test_srav(char[] a0, char[] a1, int b) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (char) (a1[i] >> b);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10433().test_srav(a0, a1, b);
    }
}
