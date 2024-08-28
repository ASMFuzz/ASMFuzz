public class MyJVMTest_1201 {

    static int[] a0 = { 0, 5, 3, 0, 2, 0, -858835216, 0, 8, 8 };

    static int[] a1 = { -1128655464, 5, 3, 0, 0, 2, 0, 0, -1780717060, -682577833 };

    static int b = 0;

    int[] test_subv(int[] a0, int[] a1, int b) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (int) (a1[i] - b);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1201().test_subv(a0, a1, b);
    }
}
