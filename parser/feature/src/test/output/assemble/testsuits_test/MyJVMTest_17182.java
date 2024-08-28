public class MyJVMTest_17182 {

    static boolean[] a = { false, false, false, true, false, false, true, false, false, true };

    static boolean[] b = { true, true, true, true, false, false, true, true, true, false };

    boolean[] test_2ci_neg(boolean[] a, boolean[] b) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = false;
            b[i] = false;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17182().test_2ci_neg(a, b);
    }
}
