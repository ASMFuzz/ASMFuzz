public class MyJVMTest_14037 {

    static boolean[] a = { false, false, true, true, false, true, true, true, false, true };

    static boolean[] b = { true, false, true, true, true, true, false, true, false, true };

    static boolean c = false;

    static boolean d = false;

    static int k = -552009354;

    int test_2vi_inv(boolean[] a, boolean[] b, boolean c, boolean d, int k) {
        for (int i = 0; i < a.length - k; i += 1) {
            a[i + k] = c;
            b[i + k] = d;
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14037().test_2vi_inv(a, b, c, d, k);
    }
}
