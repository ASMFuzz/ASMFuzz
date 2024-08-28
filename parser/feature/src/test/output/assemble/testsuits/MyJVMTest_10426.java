public class MyJVMTest_10426 {

    static byte[] a = { 92, 119, 51, 34, 48, 101, -33, -111, -78, -122 };

    static int[] b = { 0, 594934096, -590507891, 0, 0, 0, 0, 8, 4, 0 };

    byte[] test_ci_neg(byte[] a, int[] b) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = -123;
            b[i] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10426().test_ci_neg(a, b);
    }
}
