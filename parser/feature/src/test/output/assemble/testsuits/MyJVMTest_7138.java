public class MyJVMTest_7138 {

    static boolean[] a = { false, true, true, false, true, false, false, false, false, true };

    static boolean[] b = { false, false, true, true, true, true, true, true, false, true };

    static int ALIGN_OFF = 8;

    boolean[] test_2ci_aln(boolean[] a, boolean[] b) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i + ALIGN_OFF] = false;
            b[i] = false;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7138().test_2ci_aln(a, b);
    }
}
