public class MyJVMTest_14726 {

    static byte[] a = { 46, -79, -19, 91, -56, 25, 20, 108, 71, -26 };

    static byte[] b = { 28, -82, -114, -3, -28, 75, 115, -41, 36, -124 };

    static int k = 0;

    int test_cp_inv(byte[] a, byte[] b, int k) {
        for (int i = 0; i < a.length - k; i += 1) {
            a[i + k] = b[i + k];
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14726().test_cp_inv(a, b, k);
    }
}
