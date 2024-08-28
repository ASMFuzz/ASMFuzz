public class MyJVMTest_14840 {

    static boolean[] a = { true, true, true, true, false, false, true, false, false, false };

    static boolean b = true;

    static int OFFSET = 3;

    boolean[] test_vi_off(boolean[] a, boolean b) {
        for (int i = 0; i < a.length - OFFSET; i += 1) {
            a[i + OFFSET] = b;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14840().test_vi_off(a, b);
    }
}
