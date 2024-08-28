public class MyJVMTest_4044 {

    static byte[] a = { -47, -125, 67, -96, -23, -83, -57, 13, 19, 22 };

    static byte[] b = { -1, -79, 23, 62, -40, 91, -35, -23, -64, -4 };

    byte[] test_cp_neg(byte[] a, byte[] b) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = b[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4044().test_cp_neg(a, b);
    }
}
