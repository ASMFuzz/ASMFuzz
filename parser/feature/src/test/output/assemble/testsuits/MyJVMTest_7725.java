public class MyJVMTest_7725 {

    static int[] a = { -103459562, 6, 535048588, 0, 0, 3, 0, 5, 0, 1987716064 };

    static int[] b = { 6, 0, 1898845392, 574157804, 0, -1237135975, 9, -689577085, 5, 0 };

    static int k = 2049293735;

    int test_2ci_inv(int[] a, int[] b, int k) {
        for (int i = 0; i < a.length - k; i += 1) {
            a[i + k] = -123;
            b[i + k] = -103;
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7725().test_2ci_inv(a, b, k);
    }
}
