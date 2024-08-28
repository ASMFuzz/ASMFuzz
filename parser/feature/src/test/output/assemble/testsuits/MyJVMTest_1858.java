public class MyJVMTest_1858 {

    static boolean[] a = { false, false, true, true, false, false, false, false, true, true };

    static boolean[] b = { true, true, false, true, false, false, false, false, false, true };

    boolean[] test_2ci_oppos(boolean[] a, boolean[] b) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[limit - i] = false;
            b[i] = false;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1858().test_2ci_oppos(a, b);
    }
}
