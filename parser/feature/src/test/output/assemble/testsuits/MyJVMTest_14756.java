public class MyJVMTest_14756 {

    static byte[] a = { -60, -127, 0, -25, 54, -96, -119, 102, 96, -103 };

    static byte[] b = { -8, -38, 93, -70, 5, -76, -68, 86, 51, -74 };

    static byte c = 0;

    static byte d = -85;

    byte[] test_2vi(byte[] a, byte[] b, byte c, byte d) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = c;
            b[i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14756().test_2vi(a, b, c, d);
    }
}
