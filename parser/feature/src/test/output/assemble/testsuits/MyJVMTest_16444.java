public class MyJVMTest_16444 {

    static short[] a = { -32768, 0, 0, -32768, 32767, 0, -30291, -30252, 9184, -32768 };

    static short[] b = { 32767, -32768, 0, 32767, -21582, 0, 0, -32768, 32767, -25298 };

    static short c = -32652;

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
        new MyJVMTest_16444().test_2vi_inv(a, b, c, d, k);
    }
}
