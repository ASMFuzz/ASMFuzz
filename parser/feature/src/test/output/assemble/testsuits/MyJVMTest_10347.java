public class MyJVMTest_10347 {

    static byte[] a = { -39, 122, -27, 56, 51, 94, 0, 26, 48, -84 };

    static byte b = -128;

    byte[] test_vi(byte[] a, byte b) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10347().test_vi(a, b);
    }
}
