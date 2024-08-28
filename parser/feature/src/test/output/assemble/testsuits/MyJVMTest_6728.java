public class MyJVMTest_6728 {

    static char[] a = { '0', Character.MAX_VALUE, Character.MAX_VALUE, Character.MIN_VALUE, '0', Character.MAX_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, Character.MAX_VALUE };

    static int k = 1326506686;

    int test_ci_inv(char[] a, int k) {
        for (int i = 0; i < a.length - k; i += 1) {
            a[i + k] = (char) -123;
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6728().test_ci_inv(a, k);
    }
}
