public class MyJVMTest_13177 {

    static char[] a = { Character.MAX_VALUE, 'X', '0', '9', Character.MIN_VALUE, Character.MAX_VALUE, ';', Character.MIN_VALUE, '0', '\\' };

    static char[] b = { '0', '2', '0', '0', Character.MAX_VALUE, '0', Character.MIN_VALUE, 'l', Character.MAX_VALUE, '/' };

    static int OFFSET = 3;

    char[] test_cp_off(char[] a, char[] b) {
        for (int i = 0; i < a.length - OFFSET; i += 1) {
            a[i + OFFSET] = b[i + OFFSET];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13177().test_cp_off(a, b);
    }
}
