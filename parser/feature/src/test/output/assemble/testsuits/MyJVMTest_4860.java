public class MyJVMTest_4860 {

    static int[] a = { 1, -816455275, 0, 0, 3, -734635163, 0, 24441875, -1087469547, 8 };

    static int b = 9;

    static int k = -57712406;

    int test_vi_inv(int[] a, int b, int k) {
        for (int i = 0; i < a.length - k; i += 1) {
            a[i + k] = b;
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4860().test_vi_inv(a, b, k);
    }
}
