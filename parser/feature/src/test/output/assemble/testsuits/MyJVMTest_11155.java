public class MyJVMTest_11155 {

    static boolean[] a = { true, false, true, false, true, false, true, false, false, true };

    static boolean[] b = { true, true, true, false, true, false, true, false, true, true };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    boolean[] test_cp_unalndst(boolean[] a, boolean[] b) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i + UNALIGN_OFF] = b[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11155().test_cp_unalndst(a, b);
    }
}
