public class MyJVMTest_12118 {

    static boolean[] a = { false, true, false, true, false, true, false, false, false, false };

    static boolean b = false;

    static int k = 50123095;

    int test_vi_inv(boolean[] a, boolean b, int k) {
        for (int i = 0; i < a.length - k; i += 1) {
            a[i + k] = b;
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12118().test_vi_inv(a, b, k);
    }
}
