public class MyJVMTest_16225 {

    static char[] a = { Character.MAX_VALUE, '0', Character.MAX_VALUE, Character.MAX_VALUE, Character.MIN_VALUE, '0', '0', 'l', Character.MAX_VALUE, '^' };

    static int k = 3;

    int test_ci_inv(char[] a, int k) {
        for (int i = 0; i < a.length - k; i += 1) {
            a[i + k] = (char) -123;
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16225().test_ci_inv(a, k);
    }
}
