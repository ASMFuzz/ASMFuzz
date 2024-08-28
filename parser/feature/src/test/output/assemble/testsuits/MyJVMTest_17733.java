public class MyJVMTest_17733 {

    static short[] a = { 0, 13331, -32768, 32767, -16375, 22152, 0, 32767, 0, -10706 };

    static short[] b = { 0, -32768, 32767, -24395, 0, -32768, 0, 0, -31130, -32768 };

    static int k = 0;

    int test_cp_inv(short[] a, short[] b, int k) {
        for (int i = 0; i < a.length - k; i += 1) {
            a[i + k] = b[i + k];
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17733().test_cp_inv(a, b, k);
    }
}
