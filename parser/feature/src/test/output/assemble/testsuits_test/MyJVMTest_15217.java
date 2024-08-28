public class MyJVMTest_15217 {

    static char[] a0 = { Character.MAX_VALUE, '1', '0', Character.MAX_VALUE, 'G', '|', '5', Character.MAX_VALUE, Character.MAX_VALUE, Character.MAX_VALUE };

    static char[] a1 = { Character.MAX_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, '@' };

    static short[] a2 = { 0, -32768, 32767, 32767, -32768, 28016, -32768, 32767, 32767, -13963 };

    char[] test_suba(char[] a0, char[] a1, short[] a2) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (char) (a1[i] - a2[i]);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15217().test_suba(a0, a1, a2);
    }
}
