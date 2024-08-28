public class MyJVMTest_14811 {

    static int[] a = { 0, 0, 2093812536, 0, -1906251766, 9, 7, 0, -1560097724, -439560127 };

    static int[] b = { 9, 0, 1186994153, 8, 5, 6, 8, 0, -1925582574, 0 };

    static int ALIGN_OFF = 8;

    int[] test_cp_alnsrc(int[] a, int[] b) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i] = b[i + ALIGN_OFF];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14811().test_cp_alnsrc(a, b);
    }
}
