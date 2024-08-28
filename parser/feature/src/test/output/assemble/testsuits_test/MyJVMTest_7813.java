public class MyJVMTest_7813 {

    static char[] a = { '(', 'D', '0', '0', Character.MIN_VALUE, '0', Character.MAX_VALUE, 'J', Character.MIN_VALUE, '0' };

    static char[] b = { Character.MAX_VALUE, '0', '0', '0', '0', 'P', Character.MAX_VALUE, Character.MAX_VALUE, '1', 'P' };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    char[] test_cp_unalnsrc(char[] a, char[] b) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i] = b[i + UNALIGN_OFF];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7813().test_cp_unalnsrc(a, b);
    }
}
