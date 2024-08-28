public class MyJVMTest_14835 {

    static int[] a = { 0, 5, 1859368801, -92445167, 5, 0, 0, 7, 7, 5 };

    static int k = 6;

    int test_ci_inv(int[] a, int k) {
        for (int i = 0; i < a.length - k; i += 1) {
            a[i + k] = -123;
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14835().test_ci_inv(a, k);
    }
}
