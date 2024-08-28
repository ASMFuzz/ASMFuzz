public class MyJVMTest_1760 {

    static char[] a = { '0', Character.MAX_VALUE, Character.MAX_VALUE, 'w', Character.MIN_VALUE, '0', Character.MAX_VALUE, '0', Character.MIN_VALUE, 'Y' };

    static char[] b = { Character.MAX_VALUE, Character.MIN_VALUE, '.', Character.MAX_VALUE, 'K', Character.MAX_VALUE, Character.MAX_VALUE, 'C', '0', Character.MIN_VALUE };

    static int k = 1002359232;

    int test_2ci_inv(char[] a, char[] b, int k) {
        for (int i = 0; i < a.length - k; i += 1) {
            a[i + k] = (char) -123;
            b[i + k] = (char) -103;
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1760().test_2ci_inv(a, b, k);
    }
}
