public class MyJVMTest_13926 {

    static char[] a = { '[', Character.MAX_VALUE, '0', Character.MIN_VALUE, '0', '0', '0', Character.MIN_VALUE, Character.MAX_VALUE, Character.MIN_VALUE };

    static char[] b = { Character.MIN_VALUE, '0', Character.MIN_VALUE, Character.MAX_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, 'W', Character.MIN_VALUE, Character.MAX_VALUE, Character.MIN_VALUE };

    static int OFFSET = 3;

    char[] test_2ci_off(char[] a, char[] b) {
        for (int i = 0; i < a.length - OFFSET; i += 1) {
            a[i + OFFSET] = (char) -123;
            b[i + OFFSET] = (char) -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13926().test_2ci_off(a, b);
    }
}
