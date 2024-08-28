public class MyJVMTest_13283 {

    static byte[] a = { 16, 70, -59, 28, 101, 64, 6, -13, -114, -119 };

    static byte[] b = { -73, -9, -100, -21, 14, 78, -19, -109, -84, -51 };

    static short[] c = { -32768, 32767, 0, 0, 32767, -32768, -32768, -32768, 32767, 16822 };

    static short[] d = { -25385, 17301, -21711, -21090, 0, 0, 19152, 0, 29529, 32767 };

    byte[] test_cp_neg(byte[] a, byte[] b, short[] c, short[] d) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = b[i];
            c[i] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13283().test_cp_neg(a, b, c, d);
    }
}
