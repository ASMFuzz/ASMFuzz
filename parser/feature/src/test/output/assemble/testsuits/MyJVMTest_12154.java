public class MyJVMTest_12154 {

    static byte[] a = { -60, -75, -76, -57, -18, 43, -46, -79, -100, 98 };

    static short[] b = { 0, -32768, 15439, 22810, 32767, -15945, 32767, 0, 32767, 0 };

    byte[] test_ci(byte[] a, short[] b) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = -123;
            b[i] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12154().test_ci(a, b);
    }
}
