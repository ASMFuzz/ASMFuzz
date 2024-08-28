public class MyJVMTest_8044 {

    static boolean[] a = { false, true, true, true, false, false, false, true, false, true };

    boolean[] test_ci_neg(boolean[] a) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = false;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8044().test_ci_neg(a);
    }
}
