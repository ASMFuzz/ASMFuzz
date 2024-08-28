public class MyJVMTest_11396 {

    static int[] a0 = { 1, 0, 0, 0, -318590144, 2, 0, 3, 170527569, 5 };

    static int[] a1 = { 0, 1, 0, 8, 0, 0, 0, 0, 2, 0 };

    static int b = 0;

    int[] test_srlv(int[] a0, int[] a1, int b) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (int) (a1[i] >>> b);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11396().test_srlv(a0, a1, b);
    }
}
