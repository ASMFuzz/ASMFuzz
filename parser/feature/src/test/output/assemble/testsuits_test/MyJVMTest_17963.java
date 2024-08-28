public class MyJVMTest_17963 {

    static char[] a = { '0', '>', 'Z', '0', '0', Character.MAX_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, '2', Character.MAX_VALUE };

    static char[] b = { '0', 'T', '0', Character.MAX_VALUE, '0', Character.MAX_VALUE, '>', Character.MIN_VALUE, 'p', '7' };

    char[] test_cp(char[] a, char[] b) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17963().test_cp(a, b);
    }
}
