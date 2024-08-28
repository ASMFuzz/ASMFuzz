public class MyJVMTest_16200 {

    static char[] a = { Character.MIN_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, '9', '0', Character.MIN_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, 'D', '0' };

    static char[] b = { '0', '0', 'f', ':', Character.MAX_VALUE, 'M', '|', Character.MAX_VALUE, '0', 'c' };

    static int ALIGN_OFF = 8;

    char[] test_cp_alndst(char[] a, char[] b) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i + ALIGN_OFF] = b[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16200().test_cp_alndst(a, b);
    }
}
