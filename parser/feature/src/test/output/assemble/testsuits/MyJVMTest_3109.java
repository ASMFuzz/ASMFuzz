public class MyJVMTest_3109 {

    static char[] a0 = { Character.MAX_VALUE, '9', '0', Character.MIN_VALUE, Character.MIN_VALUE, 'g', 'S', '7', 'V', Character.MAX_VALUE };

    static char[] a1 = { Character.MAX_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, '0', 'a', Character.MIN_VALUE, Character.MIN_VALUE, '0', Character.MIN_VALUE, Character.MAX_VALUE };

    static short[] a2 = { 0, 0, -26340, 0, 0, -32768, -10579, 32767, 32767, 0 };

    char[] test_mula(char[] a0, char[] a1, short[] a2) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (char) (a1[i] * a2[i]);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3109().test_mula(a0, a1, a2);
    }
}
