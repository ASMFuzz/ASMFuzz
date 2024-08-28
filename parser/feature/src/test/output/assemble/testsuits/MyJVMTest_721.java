public class MyJVMTest_721 {

    static int[] a = { 2, 0, 8, 8, 5, -949136563, 3, 3, 3, 0 };

    static int[] b = { 5, -815067466, 4, 0, 0, 9, 5, 0, 0, 8 };

    static int k = 0;

    int test_cp_inv(int[] a, int[] b, int k) {
        for (int i = 0; i < a.length - k; i += 1) {
            a[i + k] = b[i + k];
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_721().test_cp_inv(a, b, k);
    }
}
