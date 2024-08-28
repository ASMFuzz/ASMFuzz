public class MyJVMTest_9835 {

    static boolean[] a = { true, true, true, false, false, true, true, false, false, true };

    static boolean[] b = { true, true, false, true, false, false, true, false, true, true };

    static int OFFSET = 3;

    boolean[] test_cp_off(boolean[] a, boolean[] b) {
        for (int i = 0; i < a.length - OFFSET; i += 1) {
            a[i + OFFSET] = b[i + OFFSET];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9835().test_cp_off(a, b);
    }
}
