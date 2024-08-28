public class MyJVMTest_9238 {

    static int[] a = { -252045681, 7, -1699990929, 8, 0, -1556085597, 9, 3, 6, 1 };

    static int b = 6;

    int test_vi_oppos(int[] a, int b) {
        int limit = a.length - 1;
        for (int i = limit; i >= 0; i -= 1) {
            a[limit - i] = b;
        }
        return limit;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9238().test_vi_oppos(a, b);
    }
}
