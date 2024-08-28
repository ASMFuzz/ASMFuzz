public class MyJVMTest_5281 {

    static byte[] a = { -25, 52, -57, -85, 40, 51, 25, -84, 89, 116 };

    byte[] test_ci_neg(byte[] a) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = -123;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5281().test_ci_neg(a);
    }
}
