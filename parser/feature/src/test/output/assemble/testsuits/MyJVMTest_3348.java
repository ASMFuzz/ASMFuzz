public class MyJVMTest_3348 {

    static char[] a = { Character.MAX_VALUE, Character.MIN_VALUE, '|', '0', '0', '0', '0', Character.MAX_VALUE, Character.MAX_VALUE, '0' };

    static char[] b = { '.', '0', '0', 'a', 'Y', 'e', Character.MAX_VALUE, Character.MAX_VALUE, '?', '0' };

    static char c = Character.MIN_VALUE;

    static char d = Character.MIN_VALUE;

    static int ALIGN_OFF = 8;

    char[] test_2vi_aln(char[] a, char[] b, char c, char d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i] = c;
            b[i + ALIGN_OFF] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3348().test_2vi_aln(a, b, c, d);
    }
}
