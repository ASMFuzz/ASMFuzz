public class MyJVMTest_16284 {

    static int[] a = { 7, 0, 0, -246247243, 8, 0, 9, 1, 2, 9 };

    static int[] b = { 3, 371991111, 7, 0, 9, 1031280449, 7, 9, 0, 7 };

    int[] test_2ci(int[] a, int[] b) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = -123;
            b[i] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16284().test_2ci(a, b);
    }
}
