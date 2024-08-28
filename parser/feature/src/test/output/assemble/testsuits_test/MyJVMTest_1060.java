public class MyJVMTest_1060 {

    static boolean[] a = { true, true, true, false, true, false, false, false, true, true };

    static boolean[] b = { false, false, false, true, true, false, false, true, true, true };

    static boolean c = false;

    static boolean d = false;

    static int ALIGN_OFF = 8;

    boolean[] test_2vi_aln(boolean[] a, boolean[] b, boolean c, boolean d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i] = c;
            b[i + ALIGN_OFF] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1060().test_2vi_aln(a, b, c, d);
    }
}
