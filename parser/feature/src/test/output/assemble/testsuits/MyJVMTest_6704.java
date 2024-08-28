public class MyJVMTest_6704 {

    static char[] a = { Character.MAX_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, 'c', '0', Character.MIN_VALUE, '0', 'r', '0', '0' };

    static char[] b = { Character.MAX_VALUE, '"', Character.MAX_VALUE, Character.MIN_VALUE, 'w', Character.MAX_VALUE, '0', Character.MAX_VALUE, Character.MIN_VALUE, '@' };

    static int ALIGN_OFF = 8;

    char[] test_cp_alndst(char[] a, char[] b) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i + ALIGN_OFF] = b[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6704().test_cp_alndst(a, b);
    }
}
