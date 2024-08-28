public class MyJVMTest_4058 {

    static short[] a = { 1062, 32767, 191, 0, 32767, 0, -25014, 14303, 22296, 32767 };

    static short b = -18614;

    static int k = 0;

    int test_vi_inv(short[] a, short b, int k) {
        for (int i = 0; i < a.length - k; i += 1) {
            a[i + k] = b;
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4058().test_vi_inv(a, b, k);
    }
}
