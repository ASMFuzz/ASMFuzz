public class MyJVMTest_333 {

    static short[] a = { 0, 0, -31203, 0, 2431, 32767, 32767, -32768, 0, 32767 };

    static int k = 0;

    int test_ci_inv(short[] a, int k) {
        for (int i = 0; i < a.length - k; i += 1) {
            a[i + k] = -123;
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_333().test_ci_inv(a, k);
    }
}
