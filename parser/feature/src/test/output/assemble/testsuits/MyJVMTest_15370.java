public class MyJVMTest_15370 {

    static char[] a = { '0', Character.MIN_VALUE, ',', Character.MIN_VALUE, Character.MAX_VALUE, 'u', '#', '0', Character.MIN_VALUE, Character.MAX_VALUE };

    static char b = 'm';

    static int k = 1;

    int test_vi_inv(char[] a, char b, int k) {
        for (int i = 0; i < a.length - k; i += 1) {
            a[i + k] = b;
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15370().test_vi_inv(a, b, k);
    }
}
