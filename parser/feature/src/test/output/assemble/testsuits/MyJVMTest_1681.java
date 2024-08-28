public class MyJVMTest_1681 {

    static boolean[] a = { true, false, false, false, false, true, false, true, true, false };

    static boolean[] b = { true, false, false, true, true, true, true, false, true, true };

    static int SCALE = 2;

    boolean[] test_cp_scl(boolean[] a, boolean[] b) {
        for (int i = 0; i * SCALE < a.length; i += 1) {
            a[i * SCALE] = b[i * SCALE];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1681().test_cp_scl(a, b);
    }
}
