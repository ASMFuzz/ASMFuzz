public class MyJVMTest_2020 {

    static int[] a = { 9, 8, 3, 4, 0, 6, 3, 0, 0, 7 };

    static int[] b = { 7, 4, 8, 7, 0, 7, 5, 3, 5, 1703363800 };

    int[] test_cp_neg(int[] a, int[] b) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = b[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2020().test_cp_neg(a, b);
    }
}
