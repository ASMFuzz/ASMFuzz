public class MyJVMTest_9262 {

    static boolean[] a = { true, true, true, false, true, true, false, true, false, true };

    static boolean b = false;

    int test_vi_oppos(boolean[] a, boolean b) {
        int limit = a.length - 1;
        for (int i = limit; i >= 0; i -= 1) {
            a[limit - i] = b;
        }
        return limit;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9262().test_vi_oppos(a, b);
    }
}
