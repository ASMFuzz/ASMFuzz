public class MyJVMTest_759 {

    static byte[] a = { -29, -73, 55, -84, 127, -54, 98, 27, 71, 5 };

    static int k = 0;

    int test_ci_inv(byte[] a, int k) {
        for (int i = 0; i < a.length - k; i += 1) {
            a[i + k] = -123;
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_759().test_ci_inv(a, k);
    }
}
