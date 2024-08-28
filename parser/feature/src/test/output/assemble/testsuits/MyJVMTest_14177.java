public class MyJVMTest_14177 {

    static byte[] a = { 119, -121, -45, 116, 60, 19, 96, 48, -5, -111 };

    static byte[] b = { -52, -95, 56, -86, -31, 63, -77, 1, -5, -16 };

    static int[] c = { 1530740344, 7, 5, 8, 4, 6, 8, 3, 5, 7 };

    static int[] d = { 5, 5, 1444916967, 1642003457, 4, 0, -1445504360, 0, 1, 0 };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    byte[] test_cp_unalndst(byte[] a, byte[] b, int[] c, int[] d) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i + UNALIGN_OFF] = b[i];
            c[i + UNALIGN_OFF] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14177().test_cp_unalndst(a, b, c, d);
    }
}
