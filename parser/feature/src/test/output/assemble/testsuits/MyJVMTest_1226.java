public class MyJVMTest_1226 {

    static byte[] a = { -106, -92, -21, 103, -25, 43, 38, 9, -19, 52 };

    static int[] b = { 9, -1102767270, -1199836567, 5, 1, -1361173360, -1286764926, 1, -1367882630, 1962863567 };

    byte[] test_ci_neg(byte[] a, int[] b) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = -123;
            b[i] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1226().test_ci_neg(a, b);
    }
}
