public class MyJVMTest_14982 {

    static byte[] a = { -9, -106, -55, -75, -81, -4, 116, -117, -76, 30 };

    static byte b = 127;

    byte[] test_vi_neg(byte[] a, byte b) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = b;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14982().test_vi_neg(a, b);
    }
}
