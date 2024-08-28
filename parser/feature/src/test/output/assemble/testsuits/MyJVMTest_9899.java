public class MyJVMTest_9899 {

    static int[] a = { 6, 9, 5, 2, 7, 0, 0, 684894833, 4, 0 };

    static int[] b = { 6, 4, 8, 9, 1, 7, 3, 0, 0, 874072615 };

    static int k = 0;

    int test_cp_inv(int[] a, int[] b, int k) {
        for (int i = 0; i < a.length - k; i += 1) {
            a[i + k] = b[i + k];
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9899().test_cp_inv(a, b, k);
    }
}
