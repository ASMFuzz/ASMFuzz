public class MyJVMTest_13470 {

    static short[] a = { 0, 32767, 12047, 0, 0, 32767, -32768, 0, 32767, 32767 };

    static short[] b = { 0, -17842, 32767, -32768, 0, -32768, -15463, 0, -32768, 0 };

    short[] test_cp_neg(short[] a, short[] b) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = b[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13470().test_cp_neg(a, b);
    }
}
