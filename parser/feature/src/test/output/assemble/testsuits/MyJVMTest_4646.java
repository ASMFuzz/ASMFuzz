public class MyJVMTest_4646 {

    static boolean[] a = { false, false, false, true, true, true, false, false, false, true };

    static boolean[] b = { true, true, true, true, true, true, true, true, true, true };

    static boolean c = true;

    static boolean d = true;

    static int k = 9;

    int test_2vi_inv(boolean[] a, boolean[] b, boolean c, boolean d, int k) {
        for (int i = 0; i < a.length - k; i += 1) {
            a[i + k] = c;
            b[i + k] = d;
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4646().test_2vi_inv(a, b, c, d, k);
    }
}
