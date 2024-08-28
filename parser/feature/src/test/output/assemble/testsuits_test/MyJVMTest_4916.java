public class MyJVMTest_4916 {

    static boolean[] a = { true, false, true, true, false, true, true, false, false, false };

    static boolean[] b = { false, false, true, true, true, true, false, true, true, false };

    static boolean c = false;

    static boolean d = false;

    static int OFFSET = 3;

    boolean[] test_2vi_off(boolean[] a, boolean[] b, boolean c, boolean d) {
        for (int i = 0; i < a.length - OFFSET; i += 1) {
            a[i + OFFSET] = c;
            b[i + OFFSET] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4916().test_2vi_off(a, b, c, d);
    }
}
