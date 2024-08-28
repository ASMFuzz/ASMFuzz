public class MyJVMTest_10192 {

    static byte[] a = { -87, -114, 84, -104, -21, 92, -10, 33, -49, 62 };

    static int[] b = { 5, 9, 0, 0, 1598023530, 2, 1321214621, -535292115, 1616290425, 652913210 };

    static byte c = 127;

    static int d = 4;

    byte[] test_vi_oppos(byte[] a, int[] b, byte c, int d) {
        int limit = a.length - 1;
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = c;
            b[limit - i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10192().test_vi_oppos(a, b, c, d);
    }
}
