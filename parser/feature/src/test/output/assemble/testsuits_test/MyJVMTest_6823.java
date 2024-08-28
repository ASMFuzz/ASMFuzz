public class MyJVMTest_6823 {

    static int[] a = { 0, 0, 1, 8, 78954523, 3, 2, 8, 0, 1184543409 };

    static int[] b = { 8, 4, 8, 2, 5, 0, 1860019353, 4, 3, 8 };

    int[] test_cp(int[] a, int[] b) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6823().test_cp(a, b);
    }
}
