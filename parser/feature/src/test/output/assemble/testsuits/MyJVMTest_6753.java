public class MyJVMTest_6753 {

    static int[] a0 = { -2098038237, -1239504921, 0, 2, 9, 1, 0, 5, 1, 3 };

    static int[] a1 = { 7, 7, 8, 0, 0, 139942073, 0, 7, 754261351, 9 };

    static int b = -1090853741;

    int[] test_sllv(int[] a0, int[] a1, int b) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (int) (a1[i] << b);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6753().test_sllv(a0, a1, b);
    }
}
