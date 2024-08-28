public class MyJVMTest_5556 {

    static boolean[] a = { true, false, true, true, false, false, false, false, false, false };

    static boolean[] b = { false, false, true, false, false, true, true, true, true, false };

    boolean[] test_2ci(boolean[] a, boolean[] b) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = false;
            b[i] = false;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5556().test_2ci(a, b);
    }
}
