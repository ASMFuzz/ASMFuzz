public class MyJVMTest_1311 {

    static char[] a0 = { '0', '<', 'o', Character.MAX_VALUE, Character.MIN_VALUE, 'o', Character.MAX_VALUE, Character.MIN_VALUE, 'K', Character.MIN_VALUE };

    static char[] a1 = { 'Q', Character.MIN_VALUE, 'd', Character.MIN_VALUE, '8', Character.MAX_VALUE, Character.MAX_VALUE, Character.MIN_VALUE, 'j', Character.MAX_VALUE };

    static short[] a2 = { 0, 0, 32767, -22073, -32768, 12571, 12809, 32767, 0, -22926 };

    char[] test_ora(char[] a0, char[] a1, short[] a2) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (char) (a1[i] | a2[i]);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1311().test_ora(a0, a1, a2);
    }
}
