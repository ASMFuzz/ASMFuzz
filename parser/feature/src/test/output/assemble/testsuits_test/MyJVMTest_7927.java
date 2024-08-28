public class MyJVMTest_7927 {

    static boolean[] a = { false, true, true, false, false, true, true, true, true, false };

    static boolean[] b = { false, true, false, false, false, false, false, true, false, true };

    static boolean c = true;

    static boolean d = true;

    boolean[] test_2vi(boolean[] a, boolean[] b, boolean c, boolean d) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = c;
            b[i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7927().test_2vi(a, b, c, d);
    }
}
