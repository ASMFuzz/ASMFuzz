public class MyJVMTest_5350 {

    static boolean[] a = { true, false, true, true, true, true, true, true, true, false };

    static boolean[] b = { true, true, true, false, true, false, true, true, true, false };

    static int ALIGN_OFF = 8;

    boolean[] test_cp_alndst(boolean[] a, boolean[] b) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i + ALIGN_OFF] = b[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5350().test_cp_alndst(a, b);
    }
}
