public class MyJVMTest_11218 {

    static byte[] a = { 98, 100, 80, -29, -77, -90, -51, -71, 32, 98 };

    static byte[] b = { -26, 122, 94, -78, 30, 40, 110, -69, 84, 106 };

    static byte c = 127;

    static byte d = 61;

    int test_2vi_oppos(byte[] a, byte[] b, byte c, byte d) {
        int limit = a.length - 1;
        for (int i = limit; i >= 0; i -= 1) {
            a[i] = c;
            b[limit - i] = d;
        }
        return limit;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11218().test_2vi_oppos(a, b, c, d);
    }
}
