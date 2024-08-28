public class MyJVMTest_14150 {

    static int[] a = { 9, 0, 0, 8, 3, 8, 3, 0, -1638369127, -1882245471 };

    static int[] b = { 2144218584, 723788996, 203989112, 4, -1277652519, 265024190, 1501467035, 3, -1300345554, 777006387 };

    static int c = 2;

    static int d = 6;

    int test_2vi_oppos(int[] a, int[] b, int c, int d) {
        int limit = a.length - 1;
        for (int i = limit; i >= 0; i -= 1) {
            a[i] = c;
            b[limit - i] = d;
        }
        return limit;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14150().test_2vi_oppos(a, b, c, d);
    }
}
