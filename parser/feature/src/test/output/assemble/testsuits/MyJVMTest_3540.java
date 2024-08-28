public class MyJVMTest_3540 {

    static boolean[] a = { true, true, false, false, false, true, true, true, false, false };

    static boolean[] b = { true, true, true, true, true, true, true, true, false, true };

    static boolean c = false;

    static boolean d = true;

    boolean[] test_2vi_neg(boolean[] a, boolean[] b, boolean c, boolean d) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = c;
            b[i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3540().test_2vi_neg(a, b, c, d);
    }
}
