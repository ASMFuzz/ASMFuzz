public class MyJVMTest_4431 {

    static boolean[] a = { false, false, true, false, false, true, true, false, false, false };

    boolean[] test_ci(boolean[] a) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = false;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4431().test_ci(a);
    }
}
