public class MyJVMTest_3932 {

    static byte[] a = { 106, -68, 8, 52, -33, -64, -52, -53, -23, 64 };

    static int SCALE = 2;

    byte[] test_ci_scl(byte[] a) {
        for (int i = 0; i * SCALE < a.length; i += 1) {
            a[i * SCALE] = -123;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3932().test_ci_scl(a);
    }
}
