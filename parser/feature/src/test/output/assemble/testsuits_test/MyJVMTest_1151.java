public class MyJVMTest_1151 {

    static byte[] a = { -90, -90, -86, 1, -111, -125, 127, -73, 83, -119 };

    static byte b = -128;

    byte[] test_vi(byte[] a, byte b) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1151().test_vi(a, b);
    }
}
