public class MyJVMTest_11048 {

    static byte[] a = { -28, -33, -116, -52, -73, -38, -112, 36, 23, 46 };

    static byte[] b = { -64, -30, 72, 35, 10, 18, -75, 10, 19, 4 };

    static short[] c = { 0, 0, 0, 7895, 0, -32768, 32767, 0, -32768, 32767 };

    static short[] d = { -32768, -22979, 32767, -32768, 18818, -32768, 32767, 0, 0, 32767 };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    byte[] test_cp_unalndst(byte[] a, byte[] b, short[] c, short[] d) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i + UNALIGN_OFF] = b[i];
            c[i + UNALIGN_OFF] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11048().test_cp_unalndst(a, b, c, d);
    }
}
