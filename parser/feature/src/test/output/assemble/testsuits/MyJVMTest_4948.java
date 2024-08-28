public class MyJVMTest_4948 {

    static byte[] a = { -52, 6, -96, 70, 27, 100, -94, -43, 24, -122 };

    static byte[] b = { 122, -105, 103, -128, -64, 45, -98, 18, -3, 33 };

    static int k = 0;

    int test_2ci_inv(byte[] a, byte[] b, int k) {
        for (int i = 0; i < a.length - k; i += 1) {
            a[i + k] = -123;
            b[i + k] = -103;
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4948().test_2ci_inv(a, b, k);
    }
}
