public class MyJVMTest_1459 {

    static byte[] a = { 101, 9, 81, -35, -69, 45, -100, -73, -16, 60 };

    static byte b = 127;

    static int SCALE = 2;

    byte[] test_vi_scl(byte[] a, byte b) {
        for (int i = 0; i * SCALE < a.length; i += 1) {
            a[i * SCALE] = b;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1459().test_vi_scl(a, b);
    }
}
