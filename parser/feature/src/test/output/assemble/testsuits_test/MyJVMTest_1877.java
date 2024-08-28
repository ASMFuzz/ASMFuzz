public class MyJVMTest_1877 {

    static boolean[] a = { true, true, false, true, false, true, false, true, true, false };

    static int OFFSET = 3;

    boolean[] test_ci_off(boolean[] a) {
        for (int i = 0; i < a.length - OFFSET; i += 1) {
            a[i + OFFSET] = false;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1877().test_ci_off(a);
    }
}
