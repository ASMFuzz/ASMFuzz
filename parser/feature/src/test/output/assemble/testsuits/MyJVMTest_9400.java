public class MyJVMTest_9400 {

    static byte[] a = { 46, 86, -48, -93, 10, 45, 59, -20, -126, 96 };

    static byte[] b = { 22, -15, -18, 47, 59, -96, -93, 125, -73, 109 };

    static int[] c = { 7, -1028385813, 5, 0, 1, 5, 9, 0, 1820892021, 0 };

    static int[] d = { 651196847, 4, 7, 0, 0, 3, 1, 5, 0, 0 };

    byte[] test_cp_oppos(byte[] a, byte[] b, int[] c, int[] d) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b[limit - i];
            c[limit - i] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9400().test_cp_oppos(a, b, c, d);
    }
}
