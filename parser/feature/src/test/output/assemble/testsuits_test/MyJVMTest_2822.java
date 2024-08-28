public class MyJVMTest_2822 {

    static boolean[] a = { true, false, false, true, true, false, true, true, true, true };

    static boolean b = false;

    static int k = 0;

    int test_vi_inv(boolean[] a, boolean b, int k) {
        for (int i = 0; i < a.length - k; i += 1) {
            a[i + k] = b;
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2822().test_vi_inv(a, b, k);
    }
}
