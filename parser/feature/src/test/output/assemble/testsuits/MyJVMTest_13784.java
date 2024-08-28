public class MyJVMTest_13784 {

    static byte[] a = { -41, 3, -103, -109, -9, 72, 8, 35, 124, 45 };

    static byte[] b = { 113, 2, -56, -48, -115, 88, 84, -44, -100, -70 };

    static int ALIGN_OFF = 8;

    byte[] test_cp_alnsrc(byte[] a, byte[] b) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i] = b[i + ALIGN_OFF];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13784().test_cp_alnsrc(a, b);
    }
}
