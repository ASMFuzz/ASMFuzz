public class MyJVMTest_9823 {

    static char[] a = { Character.MAX_VALUE, 'c', '0', Character.MAX_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, '0', Character.MAX_VALUE, Character.MAX_VALUE, '0' };

    static char[] b = { Character.MAX_VALUE, '0', Character.MAX_VALUE, 'x', Character.MAX_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, Character.MIN_VALUE, 'D', '0' };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    char[] test_cp_unalndst(char[] a, char[] b) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i + UNALIGN_OFF] = b[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9823().test_cp_unalndst(a, b);
    }
}
