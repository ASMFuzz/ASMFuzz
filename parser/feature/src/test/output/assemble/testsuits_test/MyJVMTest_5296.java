public class MyJVMTest_5296 {

    static byte[] a = { 111, -28, -68, 61, 79, -120, -35, 36, 112, 109 };

    static byte[] b = { -66, 125, 4, -57, -27, 1, -120, 35, 47, -123 };

    byte[] test_2ci_neg(byte[] a, byte[] b) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = -123;
            b[i] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5296().test_2ci_neg(a, b);
    }
}
