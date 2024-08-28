public class MyJVMTest_9296 {

    static char[] a0 = { '0', '\'', Character.MIN_VALUE, Character.MAX_VALUE, '^', '0', '0', Character.MAX_VALUE, '0', Character.MIN_VALUE };

    static char[] a1 = { Character.MIN_VALUE, Character.MAX_VALUE, 'k', '0', '4', 'w', ',', 'X', Character.MIN_VALUE, Character.MAX_VALUE };

    static int VALUE = 7;

    char[] test_mulc(char[] a0, char[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (char) (a1[i] * VALUE);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9296().test_mulc(a0, a1);
    }
}
