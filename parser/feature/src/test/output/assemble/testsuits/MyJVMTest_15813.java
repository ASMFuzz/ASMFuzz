public class MyJVMTest_15813 {

    static byte[] a = { -91, -24, 2, -110, 81, 83, -2, -47, 34, -108 };

    static byte[] b = { 104, 78, -2, 27, -100, 86, 91, 106, 91, 67 };

    static int[] c = { 0, 4, 0, 7, 5, 6, 1, 9, 8, 7 };

    static int[] d = { 0, 0, 9, 0, 7, 0, 0, 0, -551930885, 0 };

    byte[] test_cp_neg(byte[] a, byte[] b, int[] c, int[] d) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = b[i];
            c[i] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15813().test_cp_neg(a, b, c, d);
    }
}
