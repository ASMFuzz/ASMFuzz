public class MyJVMTest_135 {

    static byte[] a = { -21, -110, 76, 80, 80, 3, 31, 95, -9, 76 };

    static byte[] b = { 56, 73, 15, 105, 83, 54, -85, -12, 64, 87 };

    static int[] c = { 0, 0, 2, 0, 1, 0, 5, 7, 0, 394005689 };

    static int[] d = { 8, 8, 1, 8, 3, 2, 0, 4, 9, 1584591568 };

    static int ALIGN_OFF = 8;

    byte[] test_cp_alnsrc(byte[] a, byte[] b, int[] c, int[] d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i] = b[i + ALIGN_OFF];
            c[i] = d[i + ALIGN_OFF];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_135().test_cp_alnsrc(a, b, c, d);
    }
}
