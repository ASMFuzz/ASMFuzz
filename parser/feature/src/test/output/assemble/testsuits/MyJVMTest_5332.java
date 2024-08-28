public class MyJVMTest_5332 {

    static byte[] a = { 39, -114, -91, 104, 83, -115, 118, 20, 44, 53 };

    static byte[] b = { -111, -3, -59, 100, -9, -80, -112, 36, -86, 9 };

    static byte c = 127;

    static byte d = 0;

    byte[] test_2vi(byte[] a, byte[] b, byte c, byte d) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = c;
            b[i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5332().test_2vi(a, b, c, d);
    }
}
