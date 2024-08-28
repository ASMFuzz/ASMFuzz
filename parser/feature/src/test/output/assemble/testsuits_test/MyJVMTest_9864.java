public class MyJVMTest_9864 {

    static char[] a0 = { '0', Character.MIN_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, Character.MIN_VALUE };

    static char[] a1 = { '_', '0', 'K', Character.MIN_VALUE, Character.MIN_VALUE, 'O', '1', 'j', '0', Character.MAX_VALUE };

    static short[] a2 = { 32767, -32768, -30390, -32768, -32768, -32768, 32767, -32768, 32767, -32768 };

    char[] test_diva(char[] a0, char[] a1, short[] a2) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (char) (a1[i] / a2[i]);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9864().test_diva(a0, a1, a2);
    }
}
