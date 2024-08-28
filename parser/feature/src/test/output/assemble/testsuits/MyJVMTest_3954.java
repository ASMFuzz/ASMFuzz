public class MyJVMTest_3954 {

    static byte[] a = { 88, -7, -11, 95, 14, -100, 124, 100, -111, -60 };

    static short[] b = { 0, -32768, 0, -32768, -32768, 0, 7914, 0, 28419, -32768 };

    static byte c = -128;

    static short d = 0;

    byte[] test_vi_neg(byte[] a, short[] b, byte c, short d) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = c;
            b[i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3954().test_vi_neg(a, b, c, d);
    }
}
