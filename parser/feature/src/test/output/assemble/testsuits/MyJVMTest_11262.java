public class MyJVMTest_11262 {

    static int[] a = { -760222869, 6, 5, 8, 1, 0, 1265651271, 0, 0, -1604370255 };

    static int[] b = { 0, -1540885047, 7, 0, 5, -1428543581, -1866163360, 1, 4, 0 };

    int[] test_cp_neg(int[] a, int[] b) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = b[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11262().test_cp_neg(a, b);
    }
}
