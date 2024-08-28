public class MyJVMTest_15665 {

    static boolean[] a = { false, false, false, false, true, true, false, true, false, true };

    static int k = 0;

    int test_ci_inv(boolean[] a, int k) {
        for (int i = 0; i < a.length - k; i += 1) {
            a[i + k] = false;
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15665().test_ci_inv(a, k);
    }
}
