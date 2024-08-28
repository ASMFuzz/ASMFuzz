public class MyJVMTest_9160 {

    static char[] a = { '0', '5', Character.MIN_VALUE, '0', Character.MAX_VALUE, 'E', 'O', '_', Character.MAX_VALUE, Character.MIN_VALUE };

    static char[] b = { Character.MAX_VALUE, Character.MIN_VALUE, '0', Character.MIN_VALUE, Character.MAX_VALUE, '0', Character.MAX_VALUE, '@', 'a', Character.MAX_VALUE };

    static int SCALE = 2;

    char[] test_cp_scl(char[] a, char[] b) {
        for (int i = 0; i * SCALE < a.length; i += 1) {
            a[i * SCALE] = b[i * SCALE];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9160().test_cp_scl(a, b);
    }
}
