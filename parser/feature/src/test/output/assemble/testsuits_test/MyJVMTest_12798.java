public class MyJVMTest_12798 {

    static boolean[] a = { false, true, false, false, false, false, false, true, true, false };

    static boolean[] b = { false, true, false, false, true, false, true, false, true, false };

    static int OFFSET = 3;

    boolean[] test_2ci_off(boolean[] a, boolean[] b) {
        for (int i = 0; i < a.length - OFFSET; i += 1) {
            a[i + OFFSET] = false;
            b[i + OFFSET] = false;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12798().test_2ci_off(a, b);
    }
}
