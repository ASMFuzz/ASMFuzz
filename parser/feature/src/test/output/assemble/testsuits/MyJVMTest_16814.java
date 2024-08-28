public class MyJVMTest_16814 {

    static byte[] a = { 124, 25, -123, 119, 24, -18, 37, 124, 22, 15 };

    static int[] b = { -1315542875, 0, 1, 805168486, 8, -1801371527, 0, 0, 3, 9 };

    static byte c = 9;

    static int d = 1;

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    byte[] test_vi_unaln(byte[] a, int[] b, byte c, int d) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i] = c;
            b[i + UNALIGN_OFF] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16814().test_vi_unaln(a, b, c, d);
    }
}
