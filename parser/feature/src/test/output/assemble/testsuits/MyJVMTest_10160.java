public class MyJVMTest_10160 {

    static char[] a = { Character.MIN_VALUE, Character.MAX_VALUE, '0', '<', Character.MAX_VALUE, '0', Character.MIN_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, 's' };

    static short[] b = { 0, 32767, -9707, 0, -21185, 0, -32768, 0, 32767, -32768 };

    static int ALIGN_OFF = 8;

    char[] test_ci_aln(char[] a, short[] b) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i + ALIGN_OFF] = (char) -123;
            b[i] = (short) -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10160().test_ci_aln(a, b);
    }
}
