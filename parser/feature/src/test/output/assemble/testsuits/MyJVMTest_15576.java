public class MyJVMTest_15576 {

    static char[] a0 = { Character.MIN_VALUE, Character.MIN_VALUE, '0', Character.MAX_VALUE, '0', '0', Character.MIN_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, Character.MIN_VALUE };

    static char[] a1 = { Character.MAX_VALUE, 'f', Character.MIN_VALUE, Character.MIN_VALUE, 'z', Character.MAX_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, '0' };

    static short b = 0;

    char[] test_orv(char[] a0, char[] a1, short b) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (char) (a1[i] | b);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15576().test_orv(a0, a1, b);
    }
}
