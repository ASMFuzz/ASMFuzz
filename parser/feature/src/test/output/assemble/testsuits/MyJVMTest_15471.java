public class MyJVMTest_15471 {

    static char[] a = { Character.MAX_VALUE, Character.MIN_VALUE, '0', Character.MAX_VALUE, Character.MIN_VALUE, 'A', Character.MAX_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, '[' };

    static char[] b = { Character.MAX_VALUE, Character.MAX_VALUE, '0', Character.MAX_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, '0', Character.MAX_VALUE, Character.MAX_VALUE, Character.MIN_VALUE };

    static char c = Character.MAX_VALUE;

    static char d = Character.MAX_VALUE;

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
        new MyJVMTest_15471().test_2vi_unaln(a, b, c, d);
    }
}
