public class MyJVMTest_2441 {

    static boolean[] a = { false, true, true, true, true, true, false, true, false, false };

    static boolean[] b = { true, false, false, true, false, false, true, false, true, false };

    static boolean c = true;

    static boolean d = false;

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    boolean[] test_2vi_unaln(boolean[] a, boolean[] b, boolean c, boolean d) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i] = c;
            b[i + UNALIGN_OFF] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2441().test_2vi_unaln(a, b, c, d);
    }
}
