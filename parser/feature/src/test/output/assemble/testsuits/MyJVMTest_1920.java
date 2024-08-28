public class MyJVMTest_1920 {

    static boolean[] a = { true, false, true, true, false, false, false, false, true, true };

    static boolean[] b = { true, false, true, true, false, true, true, true, true, false };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    boolean[] test_cp_unalndst(boolean[] a, boolean[] b) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i + UNALIGN_OFF] = b[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1920().test_cp_unalndst(a, b);
    }
}
