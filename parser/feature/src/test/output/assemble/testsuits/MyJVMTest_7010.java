public class MyJVMTest_7010 {

    static int[] a0 = { 1814506101, 7, 0, 1507239909, 0, 0, -1990023309, 2, -2030677183, 6 };

    static int[] a1 = { 4, 3, 4, 0, 0, -545738957, 0, 0, -1064655950, 9 };

    static int[] a2 = { 3, 0, 3, 1564566925, 6, 7, 0, 7, 0, 4 };

    int[] test_suba(int[] a0, int[] a1, int[] a2) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (int) (a1[i] - a2[i]);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7010().test_suba(a0, a1, a2);
    }
}
