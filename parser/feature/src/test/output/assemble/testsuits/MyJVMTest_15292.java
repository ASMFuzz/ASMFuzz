public class MyJVMTest_15292 {

    static char[] a0 = { Character.MIN_VALUE, 'j', '(', '0', 'w', 'C', Character.MIN_VALUE, '0', Character.MIN_VALUE, Character.MAX_VALUE };

    static char[] a1 = { Character.MAX_VALUE, '0', ':', Character.MAX_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, '0', Character.MAX_VALUE, '5', Character.MAX_VALUE };

    static short[] a2 = { 32767, -32768, 0, 0, -32763, -32768, 24801, -30473, -32768, -21146 };

    char[] test_adda(char[] a0, char[] a1, short[] a2) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (char) (a1[i] + a2[i]);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15292().test_adda(a0, a1, a2);
    }
}
