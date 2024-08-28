public class MyJVMTest_1221 {

    static int[] a = { -528555492, -1979448141, 8, 0, 0, -893046326, 9, 5, 487215905, 0 };

    static int[] b = { 4, 5, 0, 7, 4, 1006734709, 0, 7, 4, 33726094 };

    static int SCALE = 2;

    int[] test_cp_scl(int[] a, int[] b) {
        for (int i = 0; i * SCALE < a.length; i += 1) {
            a[i * SCALE] = b[i * SCALE];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1221().test_cp_scl(a, b);
    }
}
