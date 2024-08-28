public class MyJVMTest_3371 {

    static byte[] a = { -123, 67, -87, 62, -4, -24, -96, -55, -90, 41 };

    static byte[] b = { 29, 25, -77, -75, -39, 72, 20, -23, -116, 110 };

    static short[] c = { 0, -7899, -10004, -32768, -32768, 32767, 32767, -32768, 32767, -32768 };

    static short[] d = { -32768, 32767, 32767, -32768, 5004, 32767, -32768, 32767, 32767, 6533 };

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
        new MyJVMTest_3371().test_cp_unalnsrc(a, b, c, d);
    }
}
