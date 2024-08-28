public class MyJVMTest_12813 {

    static int[] a = { 4, 0, 3, 3, 0, 2, 0, 7, 6, 8 };

    static int[] b = { 0, 4, 0, 0, 0, 5, 6, 1, 0, -580461932 };

    static int c = 9;

    static int d = 0;

    static int SCALE = 2;

    int[] test_2vi_scl(int[] a, int[] b, int c, int d) {
        for (int i = 0; i * SCALE < a.length; i += 1) {
            a[i * SCALE] = c;
            b[i * SCALE] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12813().test_2vi_scl(a, b, c, d);
    }
}
