public class MyJVMTest_2590 {

    static byte[] a = { 89, -34, 11, 76, 50, -71, -58, -81, -86, -33 };

    static byte[] b = { 115, -116, -8, -77, 59, 97, -118, -121, 119, -107 };

    static int SCALE = 2;

    byte[] test_2ci_scl(byte[] a, byte[] b) {
        for (int i = 0; i * SCALE < a.length; i += 1) {
            a[i * SCALE] = -123;
            b[i * SCALE] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2590().test_2ci_scl(a, b);
    }
}
