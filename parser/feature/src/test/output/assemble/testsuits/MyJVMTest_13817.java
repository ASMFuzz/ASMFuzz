public class MyJVMTest_13817 {

    static boolean[] a = { false, true, false, true, true, false, false, true, false, true };

    static boolean[] b = { false, false, true, true, false, false, false, true, true, true };

    boolean[] test_cp_neg(boolean[] a, boolean[] b) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = b[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13817().test_cp_neg(a, b);
    }
}
