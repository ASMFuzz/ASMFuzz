public class MyJVMTest_9171 {

    static boolean[] a = { false, true, true, false, true, false, true, false, false, true };

    boolean[] test_ci_oppos(boolean[] a) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[limit - i] = false;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9171().test_ci_oppos(a);
    }
}
