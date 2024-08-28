public class MyJVMTest_1980 {

    static byte[] a = { -121, -101, -63, -57, -22, 79, -58, -118, -27, 67 };

    static byte[] b = { 19, 41, -41, 65, -10, 100, 17, 48, 123, -99 };

    static byte c = 0;

    static byte d = 127;

    int test_2vi_oppos(byte[] a, byte[] b, byte c, byte d) {
        int limit = a.length - 1;
        for (int i = limit; i >= 0; i -= 1) {
            a[i] = c;
            b[limit - i] = d;
        }
        return limit;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1980().test_2vi_oppos(a, b, c, d);
    }
}
