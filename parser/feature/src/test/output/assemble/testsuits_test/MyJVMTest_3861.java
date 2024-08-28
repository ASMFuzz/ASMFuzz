public class MyJVMTest_3861 {

    static short[] a = { -32768, -32768, 20684, 0, -32768, -32768, 32767, -27885, 32767, 32767 };

    short[] test_ci_neg(short[] a) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = -123;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3861().test_ci_neg(a);
    }
}
