public class MyJVMTest_8039 {

    static int[] a = { 350985086, 9, 0, 5, 7, 0, 2122478194, 509019003, 2, -1977012527 };

    static int b = 0;

    int[] test_vi_neg(int[] a, int b) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = b;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8039().test_vi_neg(a, b);
    }
}
