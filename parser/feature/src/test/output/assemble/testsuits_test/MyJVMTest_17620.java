public class MyJVMTest_17620 {

    static char[] a = { Character.MAX_VALUE, Character.MAX_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, '0', ':', 'm', '0', Character.MAX_VALUE, '0' };

    static char[] b = { Character.MAX_VALUE, 'D', Character.MIN_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, '>', '0', 'c', Character.MAX_VALUE, '|' };

    static int ALIGN_OFF = 8;

    char[] test_2ci_aln(char[] a, char[] b) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i + ALIGN_OFF] = (char) -123;
            b[i] = (char) -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17620().test_2ci_aln(a, b);
    }
}
