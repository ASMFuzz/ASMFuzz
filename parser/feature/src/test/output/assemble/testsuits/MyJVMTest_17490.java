public class MyJVMTest_17490 {

    static boolean[] a = { true, true, true, false, true, false, false, false, true, false };

    static boolean[] b = { false, false, false, false, true, false, false, true, false, false };

    static boolean c = false;

    static boolean d = false;

    boolean[] test_2vi(boolean[] a, boolean[] b, boolean c, boolean d) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = c;
            b[i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17490().test_2vi(a, b, c, d);
    }
}
