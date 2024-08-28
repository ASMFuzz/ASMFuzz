public class MyJVMTest_11106 {

    static boolean[] a = { false, false, true, true, true, true, true, false, false, true };

    static int OFFSET = 3;

    boolean[] test_ci_off(boolean[] a) {
        for (int i = 0; i < a.length - OFFSET; i += 1) {
            a[i + OFFSET] = false;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11106().test_ci_off(a);
    }
}
