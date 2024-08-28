public class MyJVMTest_13911 {

    static boolean[] a = { true, false, false, true, false, false, false, false, true, true };

    static boolean b = true;

    static int SCALE = 2;

    boolean[] test_vi_scl(boolean[] a, boolean b) {
        for (int i = 0; i * SCALE < a.length; i += 1) {
            a[i * SCALE] = b;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13911().test_vi_scl(a, b);
    }
}
