public class MyJVMTest_16661 {

    static boolean[] a = { true, false, false, true, false, true, false, false, true, true };

    static boolean[] b = { false, true, true, true, true, false, false, true, false, true };

    static int ALIGN_OFF = 8;

    boolean[] test_2ci_aln(boolean[] a, boolean[] b) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i + ALIGN_OFF] = false;
            b[i] = false;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16661().test_2ci_aln(a, b);
    }
}
