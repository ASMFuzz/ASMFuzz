public class MyJVMTest_17613 {

    static boolean[] a = { false, false, false, true, true, true, false, false, true, true };

    boolean[] test_ci_neg(boolean[] a) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = false;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17613().test_ci_neg(a);
    }
}
