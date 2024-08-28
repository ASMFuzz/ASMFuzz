public class MyJVMTest_14836 {

    static boolean[] a = { true, false, false, true, false, true, false, false, false, true };

    static boolean b = true;

    boolean[] test_vi(boolean[] a, boolean b) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14836().test_vi(a, b);
    }
}
