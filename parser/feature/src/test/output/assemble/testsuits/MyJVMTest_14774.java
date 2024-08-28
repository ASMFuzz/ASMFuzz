public class MyJVMTest_14774 {

    static boolean[] a = { false, false, true, false, true, false, true, true, true, false };

    static boolean[] b = { true, false, false, true, false, false, false, false, true, true };

    static int ALIGN_OFF = 8;

    boolean[] test_cp_alndst(boolean[] a, boolean[] b) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i + ALIGN_OFF] = b[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14774().test_cp_alndst(a, b);
    }
}
