public class MyJVMTest_10812 {

    static byte[] a = { -92, 2, -20, 102, -115, 69, 31, -32, -127, -81 };

    static byte[] b = { -62, 1, -64, -78, -68, -52, -8, 94, 89, -32 };

    byte[] test_cp(byte[] a, byte[] b) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10812().test_cp(a, b);
    }
}
