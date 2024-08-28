public class MyJVMTest_5303 {

    static byte[] a = { 103, 119, 115, -73, 63, 80, -90, -107, -77, 58 };

    static byte[] b = { 89, -113, 116, -61, -5, 56, -12, -11, -77, 16 };

    static int k = 7;

    int test_cp_inv(byte[] a, byte[] b, int k) {
        for (int i = 0; i < a.length - k; i += 1) {
            a[i + k] = b[i + k];
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5303().test_cp_inv(a, b, k);
    }
}
