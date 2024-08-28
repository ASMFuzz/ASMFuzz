public class MyJVMTest_1591 {

    static byte[] a = { 113, -57, 26, -102, 59, -108, 69, -3, -42, -43 };

    static byte[] b = { -6, 98, -100, -15, 77, -128, 100, -80, -48, 115 };

    byte[] test_cp(byte[] a, byte[] b) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1591().test_cp(a, b);
    }
}
