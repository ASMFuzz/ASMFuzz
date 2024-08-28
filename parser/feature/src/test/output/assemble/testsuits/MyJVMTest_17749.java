public class MyJVMTest_17749 {

    static boolean[] a = { false, false, true, true, true, true, true, true, false, true };

    static boolean[] b = { true, true, false, true, false, true, true, true, false, true };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    boolean[] test_cp_unalnsrc(boolean[] a, boolean[] b) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i] = b[i + UNALIGN_OFF];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17749().test_cp_unalnsrc(a, b);
    }
}
