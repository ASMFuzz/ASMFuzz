public class MyJVMTest_16939 {

    static boolean[] a = { false, false, true, false, false, true, true, false, true, false };

    static boolean[] b = { false, false, false, false, false, false, true, false, true, false };

    boolean[] test_cp_oppos(boolean[] a, boolean[] b) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b[limit - i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16939().test_cp_oppos(a, b);
    }
}
