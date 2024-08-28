public class MyJVMTest_11701 {

    static byte[] a = { 74, 100, 66, -56, -12, 33, -105, -95, -100, -2 };

    static byte b = -128;

    static int OFFSET = 3;

    byte[] test_vi_off(byte[] a, byte b) {
        for (int i = 0; i < a.length - OFFSET; i += 1) {
            a[i + OFFSET] = b;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11701().test_vi_off(a, b);
    }
}
