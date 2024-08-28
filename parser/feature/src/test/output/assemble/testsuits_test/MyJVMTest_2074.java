public class MyJVMTest_2074 {

    static int[] a = { 8, 8, 0, 1, -755234073, 0, 1, 0, 8, -543034057 };

    static int[] b = { 0, 0, -1390543181, 0, 727781054, 7, 0, 0, 0, 2143924586 };

    static int c = 0;

    static int d = 0;

    static int k = 0;

    int test_2vi_inv(int[] a, int[] b, int c, int d, int k) {
        for (int i = 0; i < a.length - k; i += 1) {
            a[i + k] = c;
            b[i + k] = d;
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2074().test_2vi_inv(a, b, c, d, k);
    }
}
