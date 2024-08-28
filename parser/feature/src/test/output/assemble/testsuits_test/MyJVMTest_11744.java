public class MyJVMTest_11744 {

    static int[] a = { 7, 5, 0, -1343831822, 776704521, 7, 5, 7, 3, 0 };

    static int OFFSET = 3;

    int[] test_ci_off(int[] a) {
        for (int i = 0; i < a.length - OFFSET; i += 1) {
            a[i + OFFSET] = -123;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11744().test_ci_off(a);
    }
}
