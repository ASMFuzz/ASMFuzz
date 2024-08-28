public class MyJVMTest_7553 {

    static boolean[] a = { false, false, false, true, true, false, false, true, true, false };

    static boolean b = true;

    boolean[] test_vi_neg(boolean[] a, boolean b) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = b;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7553().test_vi_neg(a, b);
    }
}
