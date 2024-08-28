public class MyJVMTest_3077 {

    static char[] a = { Character.MAX_VALUE, 'H', '0', '0', Character.MAX_VALUE, '0', '4', '}', Character.MIN_VALUE, Character.MIN_VALUE };

    static char[] b = { Character.MIN_VALUE, '0', 'i', Character.MIN_VALUE, 'u', Character.MAX_VALUE, '0', Character.MAX_VALUE, Character.MIN_VALUE, Character.MAX_VALUE };

    static int k = 0;

    int test_cp_inv(char[] a, char[] b, int k) {
        for (int i = 0; i < a.length - k; i += 1) {
            a[i + k] = b[i + k];
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3077().test_cp_inv(a, b, k);
    }
}
