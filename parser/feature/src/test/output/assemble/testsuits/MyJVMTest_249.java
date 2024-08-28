public class MyJVMTest_249 {

    static byte[] a = { 29, 60, -107, 6, -18, 112, -24, 54, 123, 54 };

    static byte[] b = { 77, -105, 119, -81, 35, 59, 66, 53, -97, 100 };

    static int[] c = { -2115867662, 0, 1, 3, 2, -1672723145, 824570300, 3, 0, 2 };

    static int[] d = { 0, 2, 0, 9, 8, 0, 7, 2, 0, 895428002 };

    byte[] test_cp_oppos(byte[] a, byte[] b, int[] c, int[] d) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b[limit - i];
            c[limit - i] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_249().test_cp_oppos(a, b, c, d);
    }
}
