public class MyJVMTest_3948 {

    static byte[] a = { -112, 110, -20, 74, -59, 69, 28, -33, -34, 87 };

    static int[] b = { -1221062850, 0, 6, 4, 0, 1, -441580472, 1, 9, 0 };

    static byte c = 0;

    static int d = 5;

    byte[] test_vi_neg(byte[] a, int[] b, byte c, int d) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = c;
            b[i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3948().test_vi_neg(a, b, c, d);
    }
}
