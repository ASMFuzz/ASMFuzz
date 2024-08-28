public class MyJVMTest_2476 {

    static int[] a = { -1864908956, 8, 0, 8, 5, 1, 6, 0, 0, 0 };

    static int OFFSET = 3;

    int[] test_ci_off(int[] a) {
        for (int i = 0; i < a.length - OFFSET; i += 1) {
            a[i + OFFSET] = -123;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2476().test_ci_off(a);
    }
}
