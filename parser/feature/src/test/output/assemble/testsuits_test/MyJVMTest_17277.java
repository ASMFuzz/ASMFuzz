public class MyJVMTest_17277 {

    static int[] a = { 2, -1471963325, -723728164, 4, 1006888866, 774524768, 5, 0, 2, 6 };

    static int[] b = { 8, 4, 7, 0, 2055987768, -976054322, 0, 0, 0, 7 };

    static int k = 954601687;

    int test_2ci_inv(int[] a, int[] b, int k) {
        for (int i = 0; i < a.length - k; i += 1) {
            a[i + k] = -123;
            b[i + k] = -103;
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17277().test_2ci_inv(a, b, k);
    }
}
