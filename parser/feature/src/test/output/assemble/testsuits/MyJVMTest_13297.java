public class MyJVMTest_13297 {

    static byte[] a = { 5, -56, 70, 15, -116, 106, -67, -3, 5, 20 };

    static int[] b = { 0, 0, 0, -1093159296, 3, 7, 0, 5, 3, 0 };

    static byte c = 0;

    static int d = -170657125;

    byte[] test_vi_neg(byte[] a, int[] b, byte c, int d) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = c;
            b[i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13297().test_vi_neg(a, b, c, d);
    }
}
