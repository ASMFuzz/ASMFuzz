public class MyJVMTest_1888 {

    static int[] a0 = { 0, -551207080, 2, 0, 5, 8, 3, 1, 2, 5 };

    static int[] a1 = { 5, 5, -1880562376, -2068185160, 0, -1890129837, 267620564, 8, 0, -1385569570 };

    static int[] a2 = { -413437494, 1122760619, 2, 0, 6, 1477713162, 9, 0, 0, 1750497416 };

    int[] test_anda(int[] a0, int[] a1, int[] a2) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (int) (a1[i] & a2[i]);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1888().test_anda(a0, a1, a2);
    }
}
