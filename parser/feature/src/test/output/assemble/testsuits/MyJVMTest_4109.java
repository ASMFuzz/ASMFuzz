public class MyJVMTest_4109 {

    static short[] a = { -32768, 28060, 32767, 32767, -32768, 32767, 0, 0, 0, 32767 };

    static short[] b = { -32768, 0, 32767, -15680, -32768, 0, 11739, 0, -30076, 32767 };

    short[] test_cp_neg(short[] a, short[] b) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = b[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4109().test_cp_neg(a, b);
    }
}
