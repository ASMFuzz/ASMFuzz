public class MyJVMTest_11086 {

    static boolean[] a = { true, false, false, true, true, false, true, false, true, false };

    static boolean[] b = { false, true, true, true, false, false, false, true, true, false };

    boolean[] test_2ci_oppos(boolean[] a, boolean[] b) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[limit - i] = false;
            b[i] = false;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11086().test_2ci_oppos(a, b);
    }
}
