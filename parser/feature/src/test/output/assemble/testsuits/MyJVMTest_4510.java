public class MyJVMTest_4510 {

    static boolean[] a = { false, true, false, false, true, true, true, true, false, true };

    static boolean[] b = { true, false, true, true, true, true, true, true, false, false };

    static int SCALE = 2;

    boolean[] test_2ci_scl(boolean[] a, boolean[] b) {
        for (int i = 0; i * SCALE < a.length; i += 1) {
            a[i * SCALE] = false;
            b[i * SCALE] = false;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4510().test_2ci_scl(a, b);
    }
}
