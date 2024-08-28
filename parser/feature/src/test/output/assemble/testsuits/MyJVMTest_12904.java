public class MyJVMTest_12904 {

    static int[] a = { 9, 0, 0, 0, 7, 0, -1811223881, 176671498, 6, 564583202 };

    static int[] b = { 0, 9, 6, 0, 4, 5, 3, 0, 0, 0 };

    int[] test_2ci_neg(int[] a, int[] b) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = -123;
            b[i] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12904().test_2ci_neg(a, b);
    }
}
