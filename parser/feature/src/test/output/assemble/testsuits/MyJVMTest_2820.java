public class MyJVMTest_2820 {

    static short[] a = { -32768, 23838, 0, 32767, 0, -32768, 0, -32768, 32767, 0 };

    static short[] b = { 0, -32768, 32767, -32567, 32767, -32768, 0, 32767, -32768, -6084 };

    static int k = 6;

    int test_2ci_inv(short[] a, short[] b, int k) {
        for (int i = 0; i < a.length - k; i += 1) {
            a[i + k] = -123;
            b[i + k] = -103;
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2820().test_2ci_inv(a, b, k);
    }
}
