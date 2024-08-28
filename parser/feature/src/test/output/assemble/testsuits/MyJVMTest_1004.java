public class MyJVMTest_1004 {

    static byte[] a = { -47, 58, 83, -108, -57, 6, 110, 20, 27, 28 };

    static int[] b = { 26118200, 1369859221, 6, -637157295, 6, 0, 0, 7, 1, 7 };

    static byte c = 127;

    static int d = -1662491568;

    byte[] test_vi_oppos(byte[] a, int[] b, byte c, int d) {
        int limit = a.length - 1;
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = c;
            b[limit - i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1004().test_vi_oppos(a, b, c, d);
    }
}
