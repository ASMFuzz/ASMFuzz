public class MyJVMTest_12941 {

    static int[] a = { 0, 7, 0, 0, 0, 7, 3, 7, 6, 421376201 };

    int[] test_ci_neg(int[] a) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = -123;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12941().test_ci_neg(a);
    }
}
