public class MyJVMTest_3194 {

    static char[] a = { '0', Character.MAX_VALUE, Character.MIN_VALUE, '(', Character.MIN_VALUE, '0', Character.MIN_VALUE, '0', Character.MAX_VALUE, Character.MIN_VALUE };

    static char[] b = { 'a', '.', '0', '0', '0', '0', Character.MAX_VALUE, '0', Character.MIN_VALUE, Character.MIN_VALUE };

    char[] test_2ci_neg(char[] a, char[] b) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = (char) -123;
            b[i] = (char) -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3194().test_2ci_neg(a, b);
    }
}
