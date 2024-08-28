public class MyJVMTest_14260 {

    static int[] a = { 0, 3, 0, -1422645249, 5, -1044426606, 7, -1837165969, 5, 3 };

    static int b = 5;

    static int k = 0;

    int test_vi_inv(int[] a, int b, int k) {
        for (int i = 0; i < a.length - k; i += 1) {
            a[i + k] = b;
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14260().test_vi_inv(a, b, k);
    }
}
