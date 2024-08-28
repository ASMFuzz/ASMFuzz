public class MyJVMTest_10253 {

    static boolean[] a = { false, true, true, false, false, false, false, false, false, true };

    static boolean[] b = { false, true, true, true, false, false, false, false, true, false };

    static boolean c = true;

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
        new MyJVMTest_10253().test_2vi_aln(a, b, c, d);
    }
}
