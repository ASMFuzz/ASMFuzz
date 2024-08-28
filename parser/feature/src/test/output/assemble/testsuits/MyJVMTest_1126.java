public class MyJVMTest_1126 {

    static byte[] a = { 97, -35, -83, -57, -63, 100, 68, -3, -13, -28 };

    static byte b = 127;

    static int k = 9;

    int test_vi_inv(byte[] a, byte b, int k) {
        for (int i = 0; i < a.length - k; i += 1) {
            a[i + k] = b;
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1126().test_vi_inv(a, b, k);
    }
}
