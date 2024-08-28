public class MyJVMTest_7407 {

    static boolean[] a = { false, false, true, true, true, false, true, false, true, true };

    static boolean[] b = { false, false, true, false, true, false, true, true, true, true };

    boolean[] test_cp_oppos(boolean[] a, boolean[] b) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b[limit - i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7407().test_cp_oppos(a, b);
    }
}
