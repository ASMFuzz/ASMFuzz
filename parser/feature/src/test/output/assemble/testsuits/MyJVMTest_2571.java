public class MyJVMTest_2571 {

    static boolean[] a = { false, true, false, false, false, true, false, false, true, false };

    static int SCALE = 2;

    boolean[] test_ci_scl(boolean[] a) {
        for (int i = 0; i * SCALE < a.length; i += 1) {
            a[i * SCALE] = false;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2571().test_ci_scl(a);
    }
}
