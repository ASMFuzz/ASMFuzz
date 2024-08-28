public class MyJVMTest_4921 {

    static byte[] a = { 78, -96, 75, -23, 32, 70, 52, 25, 0, -126 };

    static byte[] b = { -100, -81, -94, -5, -23, -124, -89, 28, 80, -18 };

    static int OFFSET = 3;

    byte[] test_2ci_off(byte[] a, byte[] b) {
        for (int i = 0; i < a.length - OFFSET; i += 1) {
            a[i + OFFSET] = -123;
            b[i + OFFSET] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4921().test_2ci_off(a, b);
    }
}
