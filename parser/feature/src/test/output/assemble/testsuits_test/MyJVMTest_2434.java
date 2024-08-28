public class MyJVMTest_2434 {

    static byte[] a = { 74, 16, 26, 29, 36, 33, -50, 25, -41, 57 };

    static byte b = 127;

    static int OFFSET = 3;

    byte[] test_vi_off(byte[] a, byte b) {
        for (int i = 0; i < a.length - OFFSET; i += 1) {
            a[i + OFFSET] = b;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2434().test_vi_off(a, b);
    }
}
