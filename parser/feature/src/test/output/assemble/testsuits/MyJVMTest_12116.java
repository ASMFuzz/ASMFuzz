public class MyJVMTest_12116 {

    static short[] a = { -3372, 0, 32767, 0, 0, 32767, -18644, -25956, -22125, -32768 };

    static short[] b = { -32768, -32768, -32768, 32767, 0, 32767, 32767, 0, -32768, -32768 };

    static int k = -711762866;

    int test_2ci_inv(short[] a, short[] b, int k) {
        for (int i = 0; i < a.length - k; i += 1) {
            a[i + k] = -123;
            b[i + k] = -103;
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12116().test_2ci_inv(a, b, k);
    }
}
