public class MyJVMTest_12006 {

    static byte[] a = { 104, 43, 80, 71, 95, 118, 94, -69, 58, 68 };

    static short[] b = { -32768, 32767, -32768, 0, 764, 0, 0, 0, 0, -32768 };

    byte[] test_ci_neg(byte[] a, short[] b) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = -123;
            b[i] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12006().test_ci_neg(a, b);
    }
}
