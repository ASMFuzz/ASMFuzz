public class MyJVMTest_7627 {

    static int[] a0 = { 0, 0, 9, 0, 0, 4, 0, 5, 9, 5 };

    static int[] a1 = { 0, 3, 0, 6, 2101280429, 8, 9, 7, 0, 4 };

    static int SHIFT = 32;

    int[] test_sllc_o(int[] a0, int[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (int) (a1[i] << SHIFT);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7627().test_sllc_o(a0, a1);
    }
}
