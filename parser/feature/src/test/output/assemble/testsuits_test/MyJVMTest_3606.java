public class MyJVMTest_3606 {

    static int[] a = { 5, 1763321176, 3, 3, 0, 490150035, 2, 5, 2, 1185434852 };

    int[] test_ci_neg(int[] a) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = -123;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3606().test_ci_neg(a);
    }
}
