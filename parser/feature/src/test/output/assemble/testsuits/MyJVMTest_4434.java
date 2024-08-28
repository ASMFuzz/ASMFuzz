public class MyJVMTest_4434 {

    static boolean[] a = { true, true, false, false, false, false, true, true, true, true };

    static boolean[] b = { false, false, true, false, true, true, false, false, false, true };

    boolean[] test_cp_neg(boolean[] a, boolean[] b) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = b[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4434().test_cp_neg(a, b);
    }
}
