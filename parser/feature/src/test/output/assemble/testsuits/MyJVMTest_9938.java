public class MyJVMTest_9938 {

    static byte[] a = { 57, 120, -98, 51, 32, 28, -108, 58, -104, -82 };

    static int k = 836274893;

    int test_ci_inv(byte[] a, int k) {
        for (int i = 0; i < a.length - k; i += 1) {
            a[i + k] = -123;
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9938().test_ci_inv(a, k);
    }
}
