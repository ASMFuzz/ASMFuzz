public class MyJVMTest_12253 {

    static byte[] a = { 74, 115, -5, 87, -120, 83, 53, -8, -12, 55 };

    static byte[] b = { -95, 14, -1, -125, 10, -37, -16, -63, 10, -122 };

    static int OFFSET = 3;

    byte[] test_cp_off(byte[] a, byte[] b) {
        for (int i = 0; i < a.length - OFFSET; i += 1) {
            a[i + OFFSET] = b[i + OFFSET];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12253().test_cp_off(a, b);
    }
}
