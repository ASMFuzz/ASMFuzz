public class MyJVMTest_4752 {

    static int[] a = { 4, 3, 0, 0, 9, -1578795284, 1598339202, 0, 8, 3 };

    static int[] b = { 7, 327382491, 0, -1172947094, 0, 0, 4, 1026857982, -955947324, 227233090 };

    static int c = 0;

    static int d = 780191751;

    int test_2vi_oppos(int[] a, int[] b, int c, int d) {
        int limit = a.length - 1;
        for (int i = limit; i >= 0; i -= 1) {
            a[i] = c;
            b[limit - i] = d;
        }
        return limit;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4752().test_2vi_oppos(a, b, c, d);
    }
}
