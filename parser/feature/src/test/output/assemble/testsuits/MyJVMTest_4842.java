public class MyJVMTest_4842 {

    static byte[] a = { -67, -115, -44, 113, 90, 4, 92, -122, -62, 121 };

    static int[] b = { -1595643978, 0, 0, 8, 1772904821, 0, 4, 5, 7, 3 };

    byte[] test_ci_oppos(byte[] a, int[] b) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[limit - i] = -123;
            b[i] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4842().test_ci_oppos(a, b);
    }
}
