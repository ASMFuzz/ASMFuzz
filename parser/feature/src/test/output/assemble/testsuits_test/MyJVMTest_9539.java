public class MyJVMTest_9539 {

    static boolean[] a = { false, true, true, true, true, true, true, true, true, true };

    static boolean[] b = { true, true, false, false, false, false, true, false, false, false };

    static int ALIGN_OFF = 8;

    boolean[] test_cp_alnsrc(boolean[] a, boolean[] b) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i] = b[i + ALIGN_OFF];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9539().test_cp_alnsrc(a, b);
    }
}
