public class MyJVMTest_13398 {

    static byte[] a = { -50, 92, 67, 69, -13, -31, -7, 61, -77, -9 };

    static byte[] b = { 49, 5, 61, 100, 23, 91, -14, 21, 35, 49 };

    byte[] test_cp_neg(byte[] a, byte[] b) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = b[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13398().test_cp_neg(a, b);
    }
}
