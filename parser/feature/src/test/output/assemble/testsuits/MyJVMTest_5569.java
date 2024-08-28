public class MyJVMTest_5569 {

    static int[] a = { 0, 9, 5, 0, 2, 0, 6, 6, 2, -947490563 };

    static int[] b = { 2, 9, 549792240, 4, 0, 1, 0, 2, 421674185, 0 };

    static int c = 0;

    static int d = 5;

    int[] test_2vi(int[] a, int[] b, int c, int d) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = c;
            b[i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5569().test_2vi(a, b, c, d);
    }
}
