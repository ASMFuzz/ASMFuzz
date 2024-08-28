public class MyJVMTest_5846 {

    static char[] a0 = { '0', 'e', Character.MAX_VALUE, Character.MAX_VALUE, '0', Character.MIN_VALUE, 'L', '1', '?', Character.MIN_VALUE };

    static char[] a1 = { Character.MIN_VALUE, '0', Character.MAX_VALUE, '0', Character.MIN_VALUE, '0', '%', '<', '0', '\'' };

    static short[] a2 = { -32768, 32767, 0, -27355, 32767, -32768, -32768, 0, 32767, 32767 };

    char[] test_adda(char[] a0, char[] a1, short[] a2) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (char) (a1[i] + a2[i]);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5846().test_adda(a0, a1, a2);
    }
}
