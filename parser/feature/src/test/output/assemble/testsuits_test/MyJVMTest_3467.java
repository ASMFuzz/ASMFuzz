public class MyJVMTest_3467 {

    static boolean[] a = { true, false, true, true, false, true, false, false, false, true };

    static boolean[] b = { true, true, false, false, true, true, true, false, true, false };

    static int OFFSET = 3;

    boolean[] test_2ci_off(boolean[] a, boolean[] b) {
        for (int i = 0; i < a.length - OFFSET; i += 1) {
            a[i + OFFSET] = false;
            b[i + OFFSET] = false;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3467().test_2ci_off(a, b);
    }
}
