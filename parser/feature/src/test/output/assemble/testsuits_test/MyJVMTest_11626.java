public class MyJVMTest_11626 {

    static byte[] a = { -6, 26, -21, -93, -106, -115, -126, -124, 55, -44 };

    static byte[] b = { 88, 11, -90, 88, -6, -74, -23, 24, 104, -38 };

    static int SCALE = 2;

    byte[] test_cp_scl(byte[] a, byte[] b) {
        for (int i = 0; i * SCALE < a.length; i += 1) {
            a[i * SCALE] = b[i * SCALE];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11626().test_cp_scl(a, b);
    }
}
