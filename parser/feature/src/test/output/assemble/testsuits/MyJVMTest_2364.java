public class MyJVMTest_2364 {

    static byte[] a = { -67, -63, -56, -35, 13, -127, -18, -18, 88, -19 };

    static byte[] b = { -100, 17, -78, 118, -125, 33, 5, 35, 67, 51 };

    static int SCALE = 2;

    byte[] test_cp_scl(byte[] a, byte[] b) {
        for (int i = 0; i * SCALE < a.length; i += 1) {
            a[i * SCALE] = b[i * SCALE];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2364().test_cp_scl(a, b);
    }
}
