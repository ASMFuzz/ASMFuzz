public class MyJVMTest_10129 {

    static int[] a0 = { 7, -56692682, 7, 1549624876, -1654046988, 4, 0, 1, -1701369029, 8 };

    static int[] a1 = { 7, 0, 0, 0, 3, 565783654, 0, 4, 1318692193, 0 };

    static int b = 0;

    int[] test_addv(int[] a0, int[] a1, int b) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (int) (a1[i] + b);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10129().test_addv(a0, a1, b);
    }
}
