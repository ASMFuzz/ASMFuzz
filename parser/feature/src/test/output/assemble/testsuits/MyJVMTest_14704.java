public class MyJVMTest_14704 {

    static byte[] a = { 126, 89, 88, -61, 118, 35, -83, -28, 95, -39 };

    byte[] test_ci_neg(byte[] a) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = -123;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14704().test_ci_neg(a);
    }
}
