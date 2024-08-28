public class MyJVMTest_13416 {

    static short[] a = { 32767, 0, 32767, 32767, -32768, 32767, 10047, 28960, 32767, 0 };

    static short b = 0;

    static int k = 9;

    int test_vi_inv(short[] a, short b, int k) {
        for (int i = 0; i < a.length - k; i += 1) {
            a[i + k] = b;
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13416().test_vi_inv(a, b, k);
    }
}
