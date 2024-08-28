public class MyJVMTest_3623 {

    static int[] a0 = { 0, 0, 5, -836400910, 0, 1, 3, 1, 6, -1320460493 };

    static int[] a1 = { 0, -1047648481, 6, 1, 3, -1021410252, 1718271845, 7, 9, -616368383 };

    static int[] a2 = { 0, 8, 0, 4, -561815261, 1844087768, 5, 2, -681892204, 0 };

    int[] test_mula(int[] a0, int[] a1, int[] a2) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (int) (a1[i] * a2[i]);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3623().test_mula(a0, a1, a2);
    }
}
