public class MyJVMTest_11849 {

    static boolean[] a = { true, true, true, false, false, true, true, false, false, true };

    static int SCALE = 2;

    boolean[] test_ci_scl(boolean[] a) {
        for (int i = 0; i * SCALE < a.length; i += 1) {
            a[i * SCALE] = false;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11849().test_ci_scl(a);
    }
}
