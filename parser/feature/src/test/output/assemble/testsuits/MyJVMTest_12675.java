public class MyJVMTest_12675 {

    static char[] a = { 'c', '&', '0', Character.MAX_VALUE, '0', '0', '0', '_', Character.MIN_VALUE, 'C' };

    static char[] b = { Character.MAX_VALUE, '0', 'y', Character.MAX_VALUE, '%', Character.MAX_VALUE, 'B', Character.MAX_VALUE, ';', 'p' };

    static char c = Character.MAX_VALUE;

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
        new MyJVMTest_12675().test_2vi_aln(a, b, c, d);
    }
}
