public class MyJVMTest_11320 {

    static int[] a = { -1084215911, 4, 0, 0, 2, 0, 0, 0, 9, 0 };

    static int[] b = { 0, 0, 7, -1059909042, 0, 7, 1, 0, -1058094133, 0 };

    static int c = 4;

    static int d = 7;

    static int k = 1555805813;

    int test_2vi_inv(int[] a, int[] b, int c, int d, int k) {
        for (int i = 0; i < a.length - k; i += 1) {
            a[i + k] = c;
            b[i + k] = d;
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11320().test_2vi_inv(a, b, c, d, k);
    }
}
