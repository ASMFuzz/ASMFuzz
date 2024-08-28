public class MyJVMTest_6192 {

    static boolean[] a = { false, true, false, true, true, true, true, true, true, true };

    static int k = 978947602;

    int test_ci_inv(boolean[] a, int k) {
        for (int i = 0; i < a.length - k; i += 1) {
            a[i + k] = false;
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6192().test_ci_inv(a, k);
    }
}
