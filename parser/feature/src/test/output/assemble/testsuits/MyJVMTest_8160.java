public class MyJVMTest_8160 {

    static short[] a = { -32768, 0, 32767, 0, 32767, 0, 32767, -32768, -32523, 24070 };

    static short[] b = { -32768, 0, 32767, 32767, 8984, 0, -32768, -26525, -8576, 32767 };

    static int k = 0;

    int test_cp_inv(short[] a, short[] b, int k) {
        for (int i = 0; i < a.length - k; i += 1) {
            a[i + k] = b[i + k];
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8160().test_cp_inv(a, b, k);
    }
}
