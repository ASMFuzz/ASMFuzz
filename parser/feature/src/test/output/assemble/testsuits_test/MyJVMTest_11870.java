public class MyJVMTest_11870 {

    static byte[] a = { -117, -26, 91, -107, 100, -83, 23, -71, 85, -59 };

    static byte[] b = { -126, 31, -105, -22, 103, -20, 50, -88, -114, -73 };

    static int SCALE = 2;

    byte[] test_2ci_scl(byte[] a, byte[] b) {
        for (int i = 0; i * SCALE < a.length; i += 1) {
            a[i * SCALE] = -123;
            b[i * SCALE] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11870().test_2ci_scl(a, b);
    }
}
