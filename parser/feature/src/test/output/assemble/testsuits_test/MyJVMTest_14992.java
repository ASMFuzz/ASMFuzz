public class MyJVMTest_14992 {

    static boolean[] a = { true, true, false, false, false, false, true, true, false, false };

    static boolean[] b = { true, true, true, false, false, true, true, true, false, false };

    boolean[] test_2ci(boolean[] a, boolean[] b) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = false;
            b[i] = false;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14992().test_2ci(a, b);
    }
}
