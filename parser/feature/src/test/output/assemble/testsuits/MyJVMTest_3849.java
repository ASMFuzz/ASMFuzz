public class MyJVMTest_3849 {

    static char[] a = { Character.MIN_VALUE, Character.MAX_VALUE, '.', Character.MIN_VALUE, '0', Character.MIN_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, Character.MAX_VALUE };

    static char[] b = { '2', Character.MAX_VALUE, 'e', '4', '0', Character.MIN_VALUE, '0', Character.MIN_VALUE, Character.MAX_VALUE, '0' };

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
        new MyJVMTest_3849().test_2ci_unaln(a, b);
    }
}
