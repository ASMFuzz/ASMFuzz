public class MyJVMTest_12388 {

    static char[] a = { '0', 't', 'w', Character.MAX_VALUE, '0', Character.MAX_VALUE, '0', '0', Character.MIN_VALUE, 'N' };

    static char[] b = { '0', '0', '0', ')', '0', '0', Character.MAX_VALUE, 'H', Character.MIN_VALUE, Character.MAX_VALUE };

    static int k = 9;

    int test_cp_inv(char[] a, char[] b, int k) {
        for (int i = 0; i < a.length - k; i += 1) {
            a[i + k] = b[i + k];
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12388().test_cp_inv(a, b, k);
    }
}
