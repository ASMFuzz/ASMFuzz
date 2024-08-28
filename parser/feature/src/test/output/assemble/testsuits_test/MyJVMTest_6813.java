public class MyJVMTest_6813 {

    static boolean[] a = { true, true, false, false, true, true, true, true, true, false };

    static boolean[] b = { true, false, false, true, true, true, true, false, false, true };

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
        new MyJVMTest_6813().test_2vi_oppos(a, b, c, d);
    }
}
