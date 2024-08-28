public class MyJVMTest_5414 {

    static boolean[] a = { true, false, false, false, false, false, false, false, false, true };

    static boolean b = true;

    static int OFFSET = 3;

    boolean[] test_vi_off(boolean[] a, boolean b) {
        for (int i = 0; i < a.length - OFFSET; i += 1) {
            a[i + OFFSET] = b;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5414().test_vi_off(a, b);
    }
}
