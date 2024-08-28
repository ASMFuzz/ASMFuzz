public class MyJVMTest_17168 {

    static byte[] a = { -5, -12, 100, 38, -116, -92, 25, -46, -10, 106 };

    static byte[] b = { 7, -12, 25, -94, 20, -106, 29, -54, 61, -35 };

    static byte c = -128;

    static byte d = -110;

    static int k = 7;

    int test_2vi_inv(byte[] a, byte[] b, byte c, byte d, int k) {
        for (int i = 0; i < a.length - k; i += 1) {
            a[i + k] = c;
            b[i + k] = d;
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17168().test_2vi_inv(a, b, c, d, k);
    }
}
