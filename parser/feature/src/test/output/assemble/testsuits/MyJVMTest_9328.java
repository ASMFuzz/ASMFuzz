public class MyJVMTest_9328 {

    static int[] a = { 9, 8, 0, 871527508, 0, 1, 7, 6, 1, 0 };

    static int[] b = { 3, 3, 3, 0, 2014580453, 9, 0, 0, 0, 0 };

    static int SCALE = 2;

    int[] test_2ci_scl(int[] a, int[] b) {
        for (int i = 0; i * SCALE < a.length; i += 1) {
            a[i * SCALE] = -123;
            b[i * SCALE] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9328().test_2ci_scl(a, b);
    }
}
