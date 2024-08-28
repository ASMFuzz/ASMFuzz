public class MyJVMTest_13279 {

    static byte[] a = { 18, -21, -126, -82, 56, 43, -24, 108, 33, 25 };

    static int SCALE = 2;

    byte[] test_ci_scl(byte[] a) {
        for (int i = 0; i * SCALE < a.length; i += 1) {
            a[i * SCALE] = -123;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13279().test_ci_scl(a);
    }
}
