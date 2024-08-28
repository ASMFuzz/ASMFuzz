public class MyJVMTest_14719 {

    static byte[] a = { -26, -40, -36, -114, -37, -87, -28, 45, 83, 10 };

    static byte[] b = { -45, 58, 16, 55, 88, 107, -74, -27, -25, 118 };

    byte[] test_2ci_neg(byte[] a, byte[] b) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = -123;
            b[i] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14719().test_2ci_neg(a, b);
    }
}
