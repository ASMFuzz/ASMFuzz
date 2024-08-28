public class MyJVMTest_13403 {

    static int[] a = { 8, 9, 7, 8, 0, 1980295665, -1633982857, 2, 0, 4 };

    static int[] b = { 0, 8, 3, 9, 0, 1150639916, 8, 0, 3, 0 };

    int[] test_2ci_oppos(int[] a, int[] b) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[limit - i] = -123;
            b[i] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13403().test_2ci_oppos(a, b);
    }
}
