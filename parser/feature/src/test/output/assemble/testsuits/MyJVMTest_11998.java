public class MyJVMTest_11998 {

    static char[] a = { Character.MIN_VALUE, '0', Character.MAX_VALUE, Character.MIN_VALUE, '0', Character.MIN_VALUE, '0', 'L', '<', Character.MAX_VALUE };

    static short[] b = { 32767, 0, -30834, -32768, 32767, 4811, 0, 32767, 32767, 32767 };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    char[] test_ci_unaln(char[] a, short[] b) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i + UNALIGN_OFF] = (char) -123;
            b[i] = (short) -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11998().test_ci_unaln(a, b);
    }
}
