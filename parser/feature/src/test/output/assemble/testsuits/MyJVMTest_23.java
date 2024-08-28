public class MyJVMTest_23 {

    static char[] a = { '^', Character.MAX_VALUE, 'Y', '0', Character.MAX_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, '1', Character.MIN_VALUE, 'q' };

    static char[] b = { Character.MAX_VALUE, 'k', Character.MIN_VALUE, Character.MIN_VALUE, '|', Character.MIN_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, '0' };

    static int SCALE = 2;

    char[] test_cp_scl(char[] a, char[] b) {
        for (int i = 0; i * SCALE < a.length; i += 1) {
            a[i * SCALE] = b[i * SCALE];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_23().test_cp_scl(a, b);
    }
}
