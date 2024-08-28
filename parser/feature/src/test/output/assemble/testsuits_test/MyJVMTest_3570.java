public class MyJVMTest_3570 {

    static int[] a = { 0, 0, 0, 0, 0, 0, -968294874, 5, 0, 5 };

    static int[] b = { 0, 4, 0, 6, 4, 7, 6, 1, -1715297259, 1331030714 };

    int[] test_2ci_neg(int[] a, int[] b) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = -123;
            b[i] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3570().test_2ci_neg(a, b);
    }
}
