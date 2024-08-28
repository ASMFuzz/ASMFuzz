public class MyJVMTest_5197 {

    static char[] a0 = { Character.MAX_VALUE, '0', Character.MAX_VALUE, 'U', Character.MAX_VALUE, Character.MIN_VALUE, '0', Character.MIN_VALUE, '0', Character.MAX_VALUE };

    static char[] a1 = { Character.MIN_VALUE, 'z', '0', 'z', Character.MIN_VALUE, Character.MAX_VALUE, ']', '0', '0', Character.MIN_VALUE };

    static int BIT_MASK = 0xB731;

    char[] test_andc(char[] a0, char[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (char) (a1[i] & BIT_MASK);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5197().test_andc(a0, a1);
    }
}
