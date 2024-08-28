public class MyJVMTest_6027 {

    static int[] a = { 0, 9, 8, 0, 0, 6, 0, 1529305866, 0, -1252723116 };

    static int[] b = { 0, 7, 5, 9, 0, 4, 0, 0, 0, 4 };

    static int c = 0;

    static int d = 5;

    int[] test_2vi_neg(int[] a, int[] b, int c, int d) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = c;
            b[i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6027().test_2vi_neg(a, b, c, d);
    }
}
