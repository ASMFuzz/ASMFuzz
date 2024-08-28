public class MyJVMTest_10036 {

    static boolean[] a = { false, true, true, false, true, false, true, true, true, true };

    static boolean[] b = { false, false, false, false, true, true, false, true, true, false };

    static int k = 0;

    int test_cp_inv(boolean[] a, boolean[] b, int k) {
        for (int i = 0; i < a.length - k; i += 1) {
            a[i + k] = b[i + k];
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10036().test_cp_inv(a, b, k);
    }
}
