public class MyJVMTest_653 {

    static char[] a = { Character.MIN_VALUE, 'q', Character.MIN_VALUE, '0', Character.MIN_VALUE, '(', Character.MIN_VALUE, Character.MAX_VALUE, Character.MIN_VALUE, 'x' };

    static char[] b = { Character.MAX_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, 'B', '0', Character.MAX_VALUE, Character.MIN_VALUE, 'I', '6', Character.MAX_VALUE };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    char[] test_cp_unalndst(char[] a, char[] b) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i + UNALIGN_OFF] = b[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_653().test_cp_unalndst(a, b);
    }
}
