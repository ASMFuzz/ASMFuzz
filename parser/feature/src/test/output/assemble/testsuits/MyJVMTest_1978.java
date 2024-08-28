public class MyJVMTest_1978 {

    static char[] a = { Character.MAX_VALUE, Character.MAX_VALUE, 'e', '0', '0', Character.MIN_VALUE, '!', '0', '$', Character.MAX_VALUE };

    static char[] b = { Character.MIN_VALUE, 'y', '3', 'D', Character.MIN_VALUE, Character.MIN_VALUE, '0', Character.MAX_VALUE, '0', Character.MAX_VALUE };

    static int SCALE = 2;

    char[] test_2ci_scl(char[] a, char[] b) {
        for (int i = 0; i * SCALE < a.length; i += 1) {
            a[i * SCALE] = (char) -123;
            b[i * SCALE] = (char) -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1978().test_2ci_scl(a, b);
    }
}
