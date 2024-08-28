public class MyJVMTest_14318 {

    static boolean[] a = { true, true, false, false, false, false, true, false, true, false };

    static boolean[] b = { false, false, false, false, true, true, false, false, true, false };

    static boolean c = true;

    static boolean d = true;

    static int OFFSET = 3;

    boolean[] test_2vi_off(boolean[] a, boolean[] b, boolean c, boolean d) {
        for (int i = 0; i < a.length - OFFSET; i += 1) {
            a[i + OFFSET] = c;
            b[i + OFFSET] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14318().test_2vi_off(a, b, c, d);
    }
}
