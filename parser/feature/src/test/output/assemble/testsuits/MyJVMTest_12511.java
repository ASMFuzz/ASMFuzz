public class MyJVMTest_12511 {

    static char[] a = { '7', Character.MIN_VALUE, 'S', '0', Character.MAX_VALUE, Character.MIN_VALUE, 'f', 'p', Character.MAX_VALUE, 'h' };

    static char[] b = { '0', Character.MAX_VALUE, '=', Character.MAX_VALUE, '0', '[', Character.MIN_VALUE, Character.MIN_VALUE, 'U', Character.MIN_VALUE };

    char[] test_2ci_neg(char[] a, char[] b) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = (char) -123;
            b[i] = (char) -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12511().test_2ci_neg(a, b);
    }
}
