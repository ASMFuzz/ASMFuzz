public class MyJVMTest_7258 {

    static int[] a0 = { 0, 0, 6, -212659237, 9, 0, 428022513, 4, -1673678210, 0 };

    static int[] a1 = { 0, 598563247, 7, 9, 3, 2, 7, 9, 5, 7 };

    static int[] a2 = { 0, 7, 2144289159, -1907763657, 1, 1721603587, 6, 7, 0, 0 };

    int[] test_diva(int[] a0, int[] a1, int[] a2) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (int) (a1[i] / a2[i]);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7258().test_diva(a0, a1, a2);
    }
}
