public class MyJVMTest_15935 {

    static int[] a = { 9, 7, 0, 0, -928363791, 0, 5, 2, 3, 0 };

    int[] test_ci(int[] a) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = -123;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15935().test_ci(a);
    }
}
