public class MyJVMTest_4523 {

    static boolean[] a = { true, false, true, true, true, false, false, false, true, true };

    static boolean b = true;

    static int SCALE = 2;

    boolean[] test_vi_scl(boolean[] a, boolean b) {
        for (int i = 0; i * SCALE < a.length; i += 1) {
            a[i * SCALE] = b;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4523().test_vi_scl(a, b);
    }
}
