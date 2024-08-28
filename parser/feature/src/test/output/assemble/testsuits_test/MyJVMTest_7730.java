public class MyJVMTest_7730 {

    static boolean[] a = { false, false, true, true, false, true, false, false, true, false };

    static boolean[] b = { false, false, true, true, true, true, false, false, true, true };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    boolean[] test_2ci_unaln(boolean[] a, boolean[] b) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i + UNALIGN_OFF] = false;
            b[i] = false;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7730().test_2ci_unaln(a, b);
    }
}
