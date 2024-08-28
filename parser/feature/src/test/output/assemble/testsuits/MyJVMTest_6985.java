public class MyJVMTest_6985 {

    static byte[] a = { 5, 36, -36, 84, -102, -60, 61, -92, -43, -127 };

    static byte[] b = { -59, -120, -61, 48, -123, 73, -61, -112, 62, -70 };

    static int[] c = { 9, 9, 0, 2070687, 7, 5, 8, 1, 9, 4 };

    static int[] d = { 0, 0, 1, 0, 2, 6, 1787488758, 5, 2083333704, 0 };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    byte[] test_cp_unalnsrc(byte[] a, byte[] b, int[] c, int[] d) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i] = b[i + UNALIGN_OFF];
            c[i] = d[i + UNALIGN_OFF];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6985().test_cp_unalnsrc(a, b, c, d);
    }
}
