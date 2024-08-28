public class MyJVMTest_10158 {

    static boolean[] a = { false, true, true, true, false, true, false, false, false, false };

    static boolean[] b = { false, false, false, false, false, true, true, true, false, false };

    static int k = 6;

    int test_2ci_inv(boolean[] a, boolean[] b, int k) {
        for (int i = 0; i < a.length - k; i += 1) {
            a[i + k] = false;
            b[i + k] = false;
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10158().test_2ci_inv(a, b, k);
    }
}
