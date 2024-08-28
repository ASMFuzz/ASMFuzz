public class MyJVMTest_8051 {

    static char[] a = { '0', Character.MAX_VALUE, 'w', '7', Character.MIN_VALUE, 'Z', '0', Character.MIN_VALUE, Character.MIN_VALUE, Character.MAX_VALUE };

    static char[] b = { 'e', '0', '0', '0', '0', Character.MIN_VALUE, Character.MIN_VALUE, '0', '}', '0' };

    static int ALIGN_OFF = 8;

    char[] test_2ci_aln(char[] a, char[] b) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i + ALIGN_OFF] = (char) -123;
            b[i] = (char) -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8051().test_2ci_aln(a, b);
    }
}
