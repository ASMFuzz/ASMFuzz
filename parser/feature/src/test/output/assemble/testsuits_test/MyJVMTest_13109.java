public class MyJVMTest_13109 {

    static byte[] a = { -34, -13, 111, -63, 54, -94, -5, -68, 127, 9 };

    static byte[] b = { -28, 117, 18, 6, 70, -114, -53, 68, 47, 60 };

    static int[] c = { 1, 737133272, 0, 0, 0, 2, 0, 0, 0, 1994830099 };

    static int[] d = { 1874758570, 0, 7, 0, 1, 3, 4, 5, 0, 0 };

    byte[] test_cp(byte[] a, byte[] b, int[] c, int[] d) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b[i];
            c[i] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13109().test_cp(a, b, c, d);
    }
}
