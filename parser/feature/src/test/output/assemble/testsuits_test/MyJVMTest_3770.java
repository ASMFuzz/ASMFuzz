public class MyJVMTest_3770 {

    static byte[] a = { 36, 98, 66, -71, -81, -46, 53, 59, -59, -41 };

    static byte[] b = { 98, -43, -70, -85, -106, 69, -113, -66, -21, 78 };

    static int[] c = { 8, 1, 8, -1986681597, 6, 2025583150, 0, 2, 1, 8 };

    static int[] d = { 9, 5, 1072237555, 3, 7, -150031435, 1, -2070386638, 3, 598237795 };

    byte[] test_cp(byte[] a, byte[] b, int[] c, int[] d) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b[i];
            c[i] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3770().test_cp(a, b, c, d);
    }
}
