public class MyJVMTest_5409 {

    static int[] a = { 0, 5, 0, 8, 8, 7, 0, 962398352, 1, 0 };

    static int k = 1511906704;

    int test_ci_inv(int[] a, int k) {
        for (int i = 0; i < a.length - k; i += 1) {
            a[i + k] = -123;
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5409().test_ci_inv(a, k);
    }
}
