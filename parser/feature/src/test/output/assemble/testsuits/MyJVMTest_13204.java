public class MyJVMTest_13204 {

    static short[] a = { 4269, -20375, 32767, 0, 0, -11669, -32768, -32768, 16104, -27892 };

    short[] test_ci_neg(short[] a) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = -123;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13204().test_ci_neg(a);
    }
}
