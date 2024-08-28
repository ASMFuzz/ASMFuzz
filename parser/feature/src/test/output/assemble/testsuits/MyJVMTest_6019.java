public class MyJVMTest_6019 {

    static int[] a = { 6, 5, 0, 0, 0, 4, 2, 0, 0, 4 };

    static int[] b = { -5279955, 5, 0, 8, 0, 0, -343899080, 0, 0, 9 };

    static int OFFSET = 3;

    int[] test_cp_off(int[] a, int[] b) {
        for (int i = 0; i < a.length - OFFSET; i += 1) {
            a[i + OFFSET] = b[i + OFFSET];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6019().test_cp_off(a, b);
    }
}
