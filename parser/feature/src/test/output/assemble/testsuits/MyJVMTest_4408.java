public class MyJVMTest_4408 {

    static byte[] a = { 61, -128, -81, -97, 66, -94, -114, 64, -60, 95 };

    static byte[] b = { -87, -8, 54, -77, -88, -121, -73, 6, 1, -25 };

    static int ALIGN_OFF = 8;

    byte[] test_cp_alnsrc(byte[] a, byte[] b) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i] = b[i + ALIGN_OFF];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4408().test_cp_alnsrc(a, b);
    }
}
