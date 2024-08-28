public class MyJVMTest_5919 {

    static char[] a = { '0', Character.MIN_VALUE, '0', Character.MIN_VALUE, Character.MIN_VALUE, ':', '0', Character.MAX_VALUE, Character.MAX_VALUE, Character.MIN_VALUE };

    static char b = 'k';

    static int k = 7;

    int test_vi_inv(char[] a, char b, int k) {
        for (int i = 0; i < a.length - k; i += 1) {
            a[i + k] = b;
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5919().test_vi_inv(a, b, k);
    }
}
