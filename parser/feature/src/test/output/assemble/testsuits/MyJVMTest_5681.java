public class MyJVMTest_5681 {

    static int[] a0 = { 2, 1, 0, 1575265292, 3, -814310946, 0, 1, 9, 1329808852 };

    static int[] a1 = { 4, -862688703, 1, 0, 0, 912169022, -1390887586, 0, 0, 4 };

    static int b = 7;

    int[] test_srav(int[] a0, int[] a1, int b) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (int) (a1[i] >> b);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5681().test_srav(a0, a1, b);
    }
}
