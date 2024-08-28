public class MyJVMTest_3784 {

    static byte[] a = { -34, 31, -40, 119, 76, -74, 14, -105, -94, -17 };

    static byte[] b = { 41, 125, 23, 71, 95, -62, -62, -74, -12, -64 };

    static short[] c = { 0, -32768, -32768, -32768, 0, 0, 32767, -32768, 20653, 32767 };

    static short[] d = { 32767, 0, -6164, 32767, -27917, -32768, -32768, 0, 0, -32768 };

    byte[] test_cp_oppos(byte[] a, byte[] b, short[] c, short[] d) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b[limit - i];
            c[limit - i] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3784().test_cp_oppos(a, b, c, d);
    }
}
