public class MyJVMTest_5879 {

    static int[] a = { 2, 6, 0, 1358363173, 7, -20393220, 7, 1, 1, 7 };

    static int[] b = { 5, 7, -1951192105, 0, -538424163, 2, 1118847316, 340168021, 2, 6 };

    static int OFFSET = 3;

    int[] test_2ci_off(int[] a, int[] b) {
        for (int i = 0; i < a.length - OFFSET; i += 1) {
            a[i + OFFSET] = -123;
            b[i + OFFSET] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5879().test_2ci_off(a, b);
    }
}
