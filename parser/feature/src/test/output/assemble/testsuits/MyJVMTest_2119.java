public class MyJVMTest_2119 {

    static byte[] a = { 24, -56, 110, 61, 22, -81, -32, 108, 106, 25 };

    static short[] b = { -32768, 0, -32331, 32767, 32767, 19071, -20791, -32768, 0, 0 };

    static byte c = 127;

    static short d = -32768;

    byte[] test_vi(byte[] a, short[] b, byte c, short d) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = c;
            b[i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2119().test_vi(a, b, c, d);
    }
}
