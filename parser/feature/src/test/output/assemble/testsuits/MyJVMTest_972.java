public class MyJVMTest_972 {

    static boolean[] a = { false, true, true, true, true, true, true, false, true, false };

    static boolean[] b = { false, false, false, false, true, true, false, false, true, true };

    static int k = 8;

    int test_2ci_inv(boolean[] a, boolean[] b, int k) {
        for (int i = 0; i < a.length - k; i += 1) {
            a[i + k] = false;
            b[i + k] = false;
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_972().test_2ci_inv(a, b, k);
    }
}
