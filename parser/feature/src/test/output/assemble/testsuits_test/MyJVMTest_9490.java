public class MyJVMTest_9490 {

    static short[] a = { 0, 32767, 32767, -32768, 0, -11188, 32767, -32768, 11380, 0 };

    static int k = 8;

    int test_ci_inv(short[] a, int k) {
        for (int i = 0; i < a.length - k; i += 1) {
            a[i + k] = -123;
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9490().test_ci_inv(a, k);
    }
}
