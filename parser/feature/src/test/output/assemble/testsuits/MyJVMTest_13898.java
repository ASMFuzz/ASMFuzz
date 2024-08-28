public class MyJVMTest_13898 {

    static boolean[] a = { true, false, false, true, true, false, true, true, false, true };

    static boolean[] b = { true, true, false, false, false, false, true, true, true, true };

    static int SCALE = 2;

    boolean[] test_2ci_scl(boolean[] a, boolean[] b) {
        for (int i = 0; i * SCALE < a.length; i += 1) {
            a[i * SCALE] = false;
            b[i * SCALE] = false;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13898().test_2ci_scl(a, b);
    }
}
