public class MyJVMTest_11366 {

    static byte[] a = { 55, -38, 5, 31, -34, 71, -113, -33, 81, 85 };

    static short[] b = { -32768, 0, -32768, 0, 25959, 21310, 0, 0, 32767, 0 };

    static byte c = -128;

    static short d = 32767;

    byte[] test_vi(byte[] a, short[] b, byte c, short d) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = c;
            b[i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11366().test_vi(a, b, c, d);
    }
}
