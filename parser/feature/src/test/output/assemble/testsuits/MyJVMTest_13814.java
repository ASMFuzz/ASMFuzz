public class MyJVMTest_13814 {

    static boolean[] a = { false, false, false, true, true, false, false, true, false, true };

    boolean[] test_ci(boolean[] a) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = false;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13814().test_ci(a);
    }
}
