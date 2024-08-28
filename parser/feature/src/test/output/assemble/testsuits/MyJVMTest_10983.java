public class MyJVMTest_10983 {

    static char[] a = { '0', '0', '0', Character.MIN_VALUE, Character.MAX_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, Character.MIN_VALUE, Character.MAX_VALUE };

    static char[] b = { Character.MAX_VALUE, Character.MIN_VALUE, 'v', '0', 'E', 'f', 'r', 'D', Character.MAX_VALUE, '0' };

    static int k = -932627235;

    int test_2ci_inv(char[] a, char[] b, int k) {
        for (int i = 0; i < a.length - k; i += 1) {
            a[i + k] = (char) -123;
            b[i + k] = (char) -103;
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10983().test_2ci_inv(a, b, k);
    }
}
