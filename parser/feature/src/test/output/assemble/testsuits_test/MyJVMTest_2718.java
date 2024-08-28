public class MyJVMTest_2718 {

    static byte[] a = { -84, 21, -114, 77, -88, 82, 112, 35, 32, 80 };

    static short[] b = { -32768, 32767, 0, -32768, -32768, 32767, 0, 0, 0, 0 };

    byte[] test_ci_neg(byte[] a, short[] b) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = -123;
            b[i] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2718().test_ci_neg(a, b);
    }
}
