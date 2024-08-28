public class MyJVMTest_16499 {

    static byte[] a = { 63, 90, -67, -13, -76, -17, 47, -115, -53, -77 };

    static byte[] b = { 61, 74, 27, 21, -16, 92, 122, 88, 9, -90 };

    static int[] c = { 919794558, 0, 0, -836904535, 24264599, 2, -693565470, 0, 0, 6 };

    static int[] d = { 0, 0, 6, 5, 5, 0, -1202259099, 0, 0, 0 };

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
        new MyJVMTest_16499().test_cp_unalnsrc(a, b, c, d);
    }
}
