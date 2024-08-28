public class MyJVMTest_15329 {

    static int[] a = { -834105338, 0, 455620905, 7, 9, 6, -957451661, 274317300, 0, 0 };

    static int[] b = { 758895803, 1, 0, 0, 3, 8, 0, 0, 8, 6 };

    static int OFFSET = 3;

    int[] test_2ci_off(int[] a, int[] b) {
        for (int i = 0; i < a.length - OFFSET; i += 1) {
            a[i + OFFSET] = -123;
            b[i + OFFSET] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15329().test_2ci_off(a, b);
    }
}
