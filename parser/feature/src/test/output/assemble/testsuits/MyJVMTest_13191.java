public class MyJVMTest_13191 {

    static char[] a = { '0', '0', Character.MAX_VALUE, Character.MIN_VALUE, '0', Character.MAX_VALUE, 'e', Character.MIN_VALUE, '^', Character.MIN_VALUE };

    static char[] b = { Character.MAX_VALUE, '0', Character.MAX_VALUE, '1', '0', Character.MIN_VALUE, '0', '0', Character.MIN_VALUE, Character.MIN_VALUE };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    char[] test_2ci_unaln(char[] a, char[] b) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i + UNALIGN_OFF] = (char) -123;
            b[i] = (char) -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13191().test_2ci_unaln(a, b);
    }
}
