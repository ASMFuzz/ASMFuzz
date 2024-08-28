public class MyJVMTest_12874 {

    static boolean[] a = { false, false, false, true, false, true, true, true, true, false };

    static boolean[] b = { true, false, true, false, true, true, true, true, false, true };

    static boolean c = true;

    static boolean d = true;

    boolean[] test_2vi_neg(boolean[] a, boolean[] b, boolean c, boolean d) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = c;
            b[i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12874().test_2vi_neg(a, b, c, d);
    }
}
