public class MyJVMTest_4940 {

    static byte[] a = { -35, 2, -14, -122, 62, -61, -114, 5, 106, -93 };

    static byte[] b = { 56, 25, -35, -84, 57, -19, 8, 93, 23, -54 };

    static byte c = 123;

    static byte d = 0;

    static int OFFSET = 3;

    byte[] test_2vi_off(byte[] a, byte[] b, byte c, byte d) {
        for (int i = 0; i < a.length - OFFSET; i += 1) {
            a[i + OFFSET] = c;
            b[i + OFFSET] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4940().test_2vi_off(a, b, c, d);
    }
}
