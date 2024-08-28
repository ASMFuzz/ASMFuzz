public class MyJVMTest_14378 {

    static char[] a0 = { Character.MIN_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, '0', '$', Character.MIN_VALUE, Character.MIN_VALUE, '0', '0', 'I' };

    static char[] a1 = { '0', '\'', '+', Character.MAX_VALUE, '0', Character.MIN_VALUE, Character.MIN_VALUE, '0', '0', 'Y' };

    static int BIT_MASK = 0xB731;

    char[] test_orc(char[] a0, char[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (char) (a1[i] | BIT_MASK);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14378().test_orc(a0, a1);
    }
}
