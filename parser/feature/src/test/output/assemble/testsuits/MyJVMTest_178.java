public class MyJVMTest_178 {

    static int[] a = { 0, 2036555434, 7, 9, 8, 5, 503140843, 5, 5, 3 };

    static int[] b = { 0, 9, 0, 6, 0, 173661918, 0, 4, 1281997797, 1320049020 };

    static int SCALE = 2;

    int[] test_2ci_scl(int[] a, int[] b) {
        for (int i = 0; i * SCALE < a.length; i += 1) {
            a[i * SCALE] = -123;
            b[i * SCALE] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_178().test_2ci_scl(a, b);
    }
}
