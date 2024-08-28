public class MyJVMTest_12700 {

    static byte[] a = { -30, 77, -35, 39, -4, 23, 10, -94, 7, 98 };

    static byte[] b = { -66, -116, -83, -113, 119, -34, -42, -4, 38, -74 };

    static short[] c = { 24132, 397, 0, 0, 0, 0, 0, -32768, 32767, 0 };

    static short[] d = { 0, -32768, -32121, 32767, 32767, -32768, -14625, -32768, 32767, -32768 };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    byte[] test_cp_unalnsrc(byte[] a, byte[] b, short[] c, short[] d) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i] = b[i + UNALIGN_OFF];
            c[i] = d[i + UNALIGN_OFF];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12700().test_cp_unalnsrc(a, b, c, d);
    }
}
