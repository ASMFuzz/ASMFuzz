public class MyJVMTest_857 {

    static boolean[] a = { true, true, false, false, false, false, false, false, false, false };

    static boolean[] b = { true, true, false, true, false, true, false, false, false, false };

    static int k = 0;

    int test_cp_inv(boolean[] a, boolean[] b, int k) {
        for (int i = 0; i < a.length - k; i += 1) {
            a[i + k] = b[i + k];
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_857().test_cp_inv(a, b, k);
    }
}
