public class MyJVMTest_94 {

    static int[] a = { 6, 0, -680055353, -554729366, 1, 6, 983011933, 0, 6, 1 };

    static int b = 0;

    int test_vi_oppos(int[] a, int b) {
        int limit = a.length - 1;
        for (int i = limit; i >= 0; i -= 1) {
            a[limit - i] = b;
        }
        return limit;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_94().test_vi_oppos(a, b);
    }
}
