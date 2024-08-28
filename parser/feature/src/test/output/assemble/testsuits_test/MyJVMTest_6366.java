public class MyJVMTest_6366 {

    static int[] a = { 7, 0, 0, 1, 692347976, 0, 9, 0, 0, 0 };

    int[] test_ci_oppos(int[] a) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[limit - i] = -123;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6366().test_ci_oppos(a);
    }
}
