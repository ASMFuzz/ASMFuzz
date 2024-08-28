public class MyJVMTest_11643 {

    static boolean[] a = { false, false, false, false, true, true, true, true, true, true };

    static boolean[] b = { false, false, false, true, false, false, true, false, false, false };

    static boolean c = false;

    static boolean d = true;

    static int SCALE = 2;

    boolean[] test_2vi_scl(boolean[] a, boolean[] b, boolean c, boolean d) {
        for (int i = 0; i * SCALE < a.length; i += 1) {
            a[i * SCALE] = c;
            b[i * SCALE] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11643().test_2vi_scl(a, b, c, d);
    }
}
