public class MyJVMTest_8278 {

    static char[] a = { '0', Character.MAX_VALUE, Character.MAX_VALUE, Character.MIN_VALUE, '0', Character.MIN_VALUE, Character.MAX_VALUE, 'M', Character.MIN_VALUE, Character.MIN_VALUE };

    static char[] b = { Character.MIN_VALUE, 'B', 'j', Character.MIN_VALUE, 'v', Character.MAX_VALUE, 'T', Character.MAX_VALUE, Character.MAX_VALUE, '0' };

    static char c = 'l';

    static char d = Character.MAX_VALUE;

    static int k = -1758464752;

    int test_2vi_inv(char[] a, char[] b, char c, char d, int k) {
        for (int i = 0; i < a.length - k; i += 1) {
            a[i + k] = c;
            b[i + k] = d;
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8278().test_2vi_inv(a, b, c, d, k);
    }
}
