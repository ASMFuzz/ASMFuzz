public class MyJVMTest_15005 {

    static int[] a = { 1, 1633935577, 1, 472933768, 7, 1, 277101207, 1, 1, 921830177 };

    static int[] b = { 4, 2, 461814834, 0, 0, 9, 6, 9, 3, 6 };

    static int c = 8;

    static int d = 0;

    int[] test_2vi(int[] a, int[] b, int c, int d) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = c;
            b[i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15005().test_2vi(a, b, c, d);
    }
}
