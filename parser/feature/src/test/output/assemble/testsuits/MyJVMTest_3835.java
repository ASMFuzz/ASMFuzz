public class MyJVMTest_3835 {

    static char[] a = { '0', Character.MIN_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, 'h', '0', '0', Character.MAX_VALUE, '0', Character.MAX_VALUE };

    static char[] b = { Character.MIN_VALUE, 'o', 'H', '\\', '0', Character.MAX_VALUE, Character.MIN_VALUE, '0', Character.MIN_VALUE, '=' };

    static int OFFSET = 3;

    char[] test_cp_off(char[] a, char[] b) {
        for (int i = 0; i < a.length - OFFSET; i += 1) {
            a[i + OFFSET] = b[i + OFFSET];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3835().test_cp_off(a, b);
    }
}
