public class MyJVMTest_974 {

    static char[] a = { Character.MAX_VALUE, '!', 'u', Character.MAX_VALUE, Character.MAX_VALUE, '0', '0', Character.MAX_VALUE, 'Y', '0' };

    static short[] b = { 32767, 15350, 0, -24974, 0, -28156, 16708, 0, -32768, 0 };

    static int ALIGN_OFF = 8;

    char[] test_ci_aln(char[] a, short[] b) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i + ALIGN_OFF] = (char) -123;
            b[i] = (short) -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_974().test_ci_aln(a, b);
    }
}
