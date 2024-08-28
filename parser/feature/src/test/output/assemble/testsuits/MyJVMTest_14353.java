public class MyJVMTest_14353 {

    static byte[] a = { 104, 60, 25, -30, -112, -66, -120, -110, 121, -86 };

    static byte[] b = { 89, 114, -106, 62, -81, 93, -16, -113, 84, 72 };

    static int k = 9;

    int test_2ci_inv(byte[] a, byte[] b, int k) {
        for (int i = 0; i < a.length - k; i += 1) {
            a[i + k] = -123;
            b[i + k] = -103;
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14353().test_2ci_inv(a, b, k);
    }
}
