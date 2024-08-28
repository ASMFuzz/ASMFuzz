public class MyJVMTest_5410 {

    static boolean[] a = { false, false, true, true, true, true, false, true, true, false };

    static boolean b = false;

    boolean[] test_vi(boolean[] a, boolean b) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5410().test_vi(a, b);
    }
}
