public class MyJVMTest_16316 {

    static boolean[] a = { false, false, false, false, true, true, false, false, false, false };

    static boolean[] b = { false, false, true, true, true, true, false, true, false, true };

    static boolean c = false;

    static boolean d = false;

    int test_2vi_oppos(boolean[] a, boolean[] b, boolean c, boolean d) {
        int limit = a.length - 1;
        for (int i = limit; i >= 0; i -= 1) {
            a[i] = c;
            b[limit - i] = d;
        }
        return limit;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16316().test_2vi_oppos(a, b, c, d);
    }
}
