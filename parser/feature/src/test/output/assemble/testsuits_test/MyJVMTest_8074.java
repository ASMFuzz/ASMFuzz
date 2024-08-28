public class MyJVMTest_8074 {

    static int[] a = { -1184326946, 5, 4, 3, 5, 0, 0, 8, 0, 9 };

    static int[] b = { 0, 778285915, 8, 4, 8, 0, 0, 4, 554885551, 0 };

    static int c = 0;

    static int d = 5;

    static int OFFSET = 3;

    int[] test_2vi_off(int[] a, int[] b, int c, int d) {
        for (int i = 0; i < a.length - OFFSET; i += 1) {
            a[i + OFFSET] = c;
            b[i + OFFSET] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8074().test_2vi_off(a, b, c, d);
    }
}
