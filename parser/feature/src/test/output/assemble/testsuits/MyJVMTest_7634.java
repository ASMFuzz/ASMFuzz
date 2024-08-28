public class MyJVMTest_7634 {

    static boolean[] a = { true, true, false, false, true, false, true, false, false, true };

    static boolean[] b = { false, false, false, false, true, false, true, true, false, true };

    boolean[] test_2ci_neg(boolean[] a, boolean[] b) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = false;
            b[i] = false;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7634().test_2ci_neg(a, b);
    }
}
