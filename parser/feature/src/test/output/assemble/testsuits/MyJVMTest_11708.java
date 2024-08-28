public class MyJVMTest_11708 {

    static boolean[] a = { true, false, true, false, false, true, true, true, true, false };

    static boolean[] b = { true, false, true, false, false, false, false, false, true, false };

    static boolean c = true;

    static boolean d = true;

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
        new MyJVMTest_11708().test_2vi_unaln(a, b, c, d);
    }
}
