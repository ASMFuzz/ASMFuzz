public class MyJVMTest_14242 {

    static byte[] a = { 61, -112, -13, -104, 54, 80, 93, 6, 118, -41 };

    static int[] b = { 4, 0, 2, 5, 586762815, 6, 6, 0, 2, 8 };

    byte[] test_ci_oppos(byte[] a, int[] b) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[limit - i] = -123;
            b[i] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14242().test_ci_oppos(a, b);
    }
}
