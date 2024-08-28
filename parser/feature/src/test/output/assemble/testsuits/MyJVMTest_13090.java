public class MyJVMTest_13090 {

    static char[] a0 = { Character.MAX_VALUE, Character.MIN_VALUE, '0', Character.MIN_VALUE, '0', Character.MIN_VALUE, 'j', '0', '0', Character.MIN_VALUE };

    static char[] a1 = { 'D', Character.MAX_VALUE, '3', Character.MAX_VALUE, Character.MAX_VALUE, '0', Character.MAX_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, '0' };

    static short[] a2 = { -32768, 32767, 9760, -32768, -32768, -32768, -14758, -32768, 32767, 32767 };

    char[] test_anda(char[] a0, char[] a1, short[] a2) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (char) (a1[i] & a2[i]);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13090().test_anda(a0, a1, a2);
    }
}
