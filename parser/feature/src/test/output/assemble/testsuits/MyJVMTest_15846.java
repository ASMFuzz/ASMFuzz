public class MyJVMTest_15846 {

    static int[] a = { 0, 1, 7, 5, 5, 0, 0, 2035214430, 741786400, 1716171753 };

    int[] test_ci_oppos(int[] a) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[limit - i] = -123;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15846().test_ci_oppos(a);
    }
}
