public class MyJVMTest_32 {

    static boolean[] a = { true, true, true, false, true, false, false, true, true, false };

    boolean[] test_ci_oppos(boolean[] a) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[limit - i] = false;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_32().test_ci_oppos(a);
    }
}
