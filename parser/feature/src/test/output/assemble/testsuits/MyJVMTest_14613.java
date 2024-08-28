public class MyJVMTest_14613 {

    static char[] a0 = { Character.MAX_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, 'Y', '0', 'O', 'F', '0', 'g', '0' };

    static char[] a1 = { Character.MAX_VALUE, 'g', Character.MAX_VALUE, '0', Character.MAX_VALUE, Character.MAX_VALUE, '0', Character.MAX_VALUE, Character.MIN_VALUE, '0' };

    static int BIT_MASK = 0xB731;

    char[] test_andc(char[] a0, char[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (char) (a1[i] & BIT_MASK);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14613().test_andc(a0, a1);
    }
}
