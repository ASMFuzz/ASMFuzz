public class MyJVMTest_10903 {

    static boolean[] a = { false, true, true, false, false, false, false, true, true, false };

    static boolean[] b = { true, true, true, true, true, false, true, false, true, false };

    static int SCALE = 2;

    boolean[] test_cp_scl(boolean[] a, boolean[] b) {
        for (int i = 0; i * SCALE < a.length; i += 1) {
            a[i * SCALE] = b[i * SCALE];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10903().test_cp_scl(a, b);
    }
}
