public class MyJVMTest_664 {

    static boolean[] a = { true, true, false, false, false, false, false, false, true, true };

    static boolean[] b = { false, false, false, false, false, true, false, true, true, false };

    static int OFFSET = 3;

    boolean[] test_cp_off(boolean[] a, boolean[] b) {
        for (int i = 0; i < a.length - OFFSET; i += 1) {
            a[i + OFFSET] = b[i + OFFSET];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_664().test_cp_off(a, b);
    }
}
