public class MyJVMTest_14323 {

    static byte[] a = { -1, -104, 33, 96, 2, 90, -72, -114, 9, -111 };

    static byte[] b = { 49, -116, -71, -63, -76, -113, 51, 84, -66, 36 };

    static int OFFSET = 3;

    byte[] test_2ci_off(byte[] a, byte[] b) {
        for (int i = 0; i < a.length - OFFSET; i += 1) {
            a[i + OFFSET] = -123;
            b[i + OFFSET] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14323().test_2ci_off(a, b);
    }
}
