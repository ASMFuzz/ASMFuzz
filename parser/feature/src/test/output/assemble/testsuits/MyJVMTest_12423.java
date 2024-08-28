public class MyJVMTest_12423 {

    static char[] a0 = { Character.MIN_VALUE, 'P', Character.MIN_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, 'f' };

    static char[] a1 = { Character.MIN_VALUE, Character.MAX_VALUE, '\'', Character.MIN_VALUE, Character.MIN_VALUE, '4', '0', 'F', Character.MIN_VALUE, Character.MAX_VALUE };

    static short[] a2 = { -22917, -32768, 32767, -32768, 22412, 0, 32767, 0, 32767, -8570 };

    char[] test_mula(char[] a0, char[] a1, short[] a2) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (char) (a1[i] * a2[i]);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12423().test_mula(a0, a1, a2);
    }
}
