public class MyJVMTest_7622 {

    static byte[] a = { 86, 28, -127, -55, 61, -49, -109, 119, 121, 118 };

    static byte[] b = { 71, -37, 18, 26, 1, 123, 75, 84, 117, 107 };

    static byte c = 127;

    static byte d = -128;

    static int k = 6;

    int test_2vi_inv(byte[] a, byte[] b, byte c, byte d, int k) {
        for (int i = 0; i < a.length - k; i += 1) {
            a[i + k] = c;
            b[i + k] = d;
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7622().test_2vi_inv(a, b, c, d, k);
    }
}
