public class MyJVMTest_1261 {

    static char[] a0 = { 'V', 'o', 'G', '0', Character.MAX_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, Character.MIN_VALUE, '@', '0' };

    static char[] a1 = { Character.MIN_VALUE, Character.MAX_VALUE, 'I', Character.MAX_VALUE, '0', Character.MAX_VALUE, '5', 'p', '0', '0' };

    static int SHIFT = 16;

    char[] test_srlc_o(char[] a0, char[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (char) (a1[i] >>> SHIFT);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1261().test_srlc_o(a0, a1);
    }
}
