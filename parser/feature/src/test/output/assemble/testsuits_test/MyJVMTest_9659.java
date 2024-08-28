public class MyJVMTest_9659 {

    static boolean[] a = { true, false, false, true, true, false, true, true, false, false };

    static boolean[] b = { false, true, true, false, false, false, true, false, true, false };

    boolean[] test_cp(boolean[] a, boolean[] b) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9659().test_cp(a, b);
    }
}
