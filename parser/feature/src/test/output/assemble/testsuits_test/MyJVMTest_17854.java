public class MyJVMTest_17854 {

    static char[] a = { '0', Character.MAX_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, '0', 'W', Character.MIN_VALUE, '0', Character.MAX_VALUE, Character.MAX_VALUE };

    static char[] b = { ',', '0', 'Z', Character.MAX_VALUE, '0', '0', 'i', Character.MAX_VALUE, '=', Character.MIN_VALUE };

    static char c = '0';

    static char d = 'h';

    static int k = -458225647;

    int test_2vi_inv(char[] a, char[] b, char c, char d, int k) {
        for (int i = 0; i < a.length - k; i += 1) {
            a[i + k] = c;
            b[i + k] = d;
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17854().test_2vi_inv(a, b, c, d, k);
    }
}
