public class MyJVMTest_1996 {

    static int[] a = { 7, 9, 1, -65201529, 0, 851838905, 0, 0, 0, 0 };

    static int SCALE = 2;

    int[] test_ci_scl(int[] a) {
        for (int i = 0; i * SCALE < a.length; i += 1) {
            a[i * SCALE] = -123;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1996().test_ci_scl(a);
    }
}
