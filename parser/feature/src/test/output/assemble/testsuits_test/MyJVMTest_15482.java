public class MyJVMTest_15482 {

    static int[] a = { 0, 5, -386295343, 0, 2, 4, 7, 0, 9, 0 };

    static int[] b = { 0, 0, 1391477926, -879895235, 0, 3, 4, 0, 6, -157172510 };

    static int c = 0;

    static int d = 0;

    int[] test_2vi_neg(int[] a, int[] b, int c, int d) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = c;
            b[i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15482().test_2vi_neg(a, b, c, d);
    }
}
