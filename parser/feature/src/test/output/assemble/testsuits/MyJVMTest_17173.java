public class MyJVMTest_17173 {

    static int[] a0 = { 0, 6, 1642340897, 290340062, 0, 6, 0, 9, -708739801, 0 };

    static int[] a1 = { 1130680185, 1745407731, 0, 0, 1435163489, 0, 3, 0, 4, -1511788824 };

    static int SHIFT = 32;

    int[] test_sllc_o(int[] a0, int[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (int) (a1[i] << SHIFT);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17173().test_sllc_o(a0, a1);
    }
}
