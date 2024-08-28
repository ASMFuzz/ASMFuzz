public class MyJVMTest_692 {

    static char[] a0 = { Character.MAX_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, Character.MIN_VALUE, ',', Character.MIN_VALUE };

    static char[] a1 = { Character.MIN_VALUE, '0', 'A', 'J', Character.MIN_VALUE, 'h', ']', Character.MIN_VALUE, Character.MAX_VALUE, Character.MIN_VALUE };

    static short[] a2 = { -4047, -28666, -11045, 20341, 0, -32768, -17556, -32768, -32768, 0 };

    char[] test_diva(char[] a0, char[] a1, short[] a2) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (char) (a1[i] / a2[i]);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_692().test_diva(a0, a1, a2);
    }
}
