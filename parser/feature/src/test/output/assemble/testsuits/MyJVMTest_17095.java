public class MyJVMTest_17095 {

    static boolean[] a = { true, true, false, false, false, true, true, true, true, false };

    static boolean b = false;

    boolean[] test_vi_neg(boolean[] a, boolean b) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = b;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17095().test_vi_neg(a, b);
    }
}
