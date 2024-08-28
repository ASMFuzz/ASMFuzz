public class MyJVMTest_6016 {

    static char[] a = { 'G', Character.MAX_VALUE, Character.MAX_VALUE, 'K', '9', '0', '0', '0', 'G', Character.MAX_VALUE };

    static char[] b = { Character.MIN_VALUE, Character.MIN_VALUE, 'k', Character.MIN_VALUE, 'N', '0', '0', Character.MIN_VALUE, '0', Character.MIN_VALUE };

    static char c = Character.MIN_VALUE;

    static char d = '?';

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    char[] test_2vi_unaln(char[] a, char[] b, char c, char d) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i] = c;
            b[i + UNALIGN_OFF] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6016().test_2vi_unaln(a, b, c, d);
    }
}
