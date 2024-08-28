public class MyJVMTest_6934 {

    static short[] a = { 32767, -18042, 32767, 32767, -32768, -32768, -19451, -32768, 32767, 0 };

    static short[] b = { 32767, -943, 32767, 0, 2022, 8955, -1784, -32768, 32013, 32767 };

    static short c = -32768;

    static short d = 0;

    static int k = 0;

    int test_2vi_inv(short[] a, short[] b, short c, short d, int k) {
        for (int i = 0; i < a.length - k; i += 1) {
            a[i + k] = c;
            b[i + k] = d;
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6934().test_2vi_inv(a, b, c, d, k);
    }
}
