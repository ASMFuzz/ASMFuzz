public class MyJVMTest_2380 {

    static boolean[] a = { true, true, false, false, true, true, false, false, false, false };

    static boolean[] b = { false, false, true, true, false, false, true, true, true, false };

    static boolean c = true;

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
        new MyJVMTest_2380().test_2vi_scl(a, b, c, d);
    }
}
