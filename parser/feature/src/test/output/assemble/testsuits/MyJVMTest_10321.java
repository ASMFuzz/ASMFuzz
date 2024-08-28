public class MyJVMTest_10321 {

    static byte[] a = { 8, 81, 115, 96, -27, -46, -84, 108, 79, -63 };

    static byte b = -128;

    static int k = 9;

    int test_vi_inv(byte[] a, byte b, int k) {
        for (int i = 0; i < a.length - k; i += 1) {
            a[i + k] = b;
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10321().test_vi_inv(a, b, k);
    }
}
