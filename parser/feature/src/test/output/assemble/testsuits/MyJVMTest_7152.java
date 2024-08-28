public class MyJVMTest_7152 {

    static byte[] a = { -69, -41, -32, -50, -88, 63, 23, -3, -27, 110 };

    static short[] b = { -3972, -32768, 32767, -30859, 0, 32767, 12353, -32768, -11715, 0 };

    static byte c = 0;

    static short d = 32767;

    byte[] test_vi_oppos(byte[] a, short[] b, byte c, short d) {
        int limit = a.length - 1;
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = c;
            b[limit - i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7152().test_vi_oppos(a, b, c, d);
    }
}
