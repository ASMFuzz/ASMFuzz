public class MyJVMTest_764 {

    static int[] a = { 8, 0, 173045338, 6, 7, 1, 8, -53499094, 6, 3 };

    static int[] b = { 7, 2, 334002413, 7, -602574340, 0, 0, 1692548136, 0, 3 };

    static int j = 9;

    int m(int[] a, int[] b, int j) {
        for (int i = 0; i < 10; i++) {
            a[i] = i;
        }
        a[j] = 0;
        a[j + 5] = 0;
        b[j + 4] = 0;
        return j;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_764().m(a, b, j);
    }
}
