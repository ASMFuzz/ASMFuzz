public class MyJVMTest_10515 {

    static char[] a0 = { '5', Character.MIN_VALUE, 'W', '0', Character.MIN_VALUE, ';', 'p', 'H', ';', Character.MAX_VALUE };

    static char[] a1 = { 'H', 'g', Character.MAX_VALUE, 'W', '!', '4', '}', Character.MAX_VALUE, Character.MIN_VALUE, Character.MAX_VALUE };

    static short[] a2 = { 0, -32768, 32767, 0, 0, 5806, 0, -32768, 0, 32767 };

    char[] test_ora(char[] a0, char[] a1, short[] a2) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (char) (a1[i] | a2[i]);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10515().test_ora(a0, a1, a2);
    }
}
