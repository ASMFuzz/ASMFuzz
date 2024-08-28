public class MyJVMTest_11821 {

    static byte[] a = { 26, 87, -86, 21, -50, 11, -127, -94, 44, -42 };

    static byte[] b = { -16, -122, 80, 76, 37, -1, -60, 52, -70, -115 };

    static int[] c = { 2, 6, 1289498956, 0, 7, 0, 2, 1238627788, 0, 0 };

    static int[] d = { 8, 6, 3, 0, -2015317685, 894160933, -2119085406, -1702364629, -51908508, 5 };

    static int ALIGN_OFF = 8;

    byte[] test_cp_alndst(byte[] a, byte[] b, int[] c, int[] d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i + ALIGN_OFF] = b[i];
            c[i + ALIGN_OFF] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11821().test_cp_alndst(a, b, c, d);
    }
}
