public class MyJVMTest_12959 {

    static int[] a0 = { 2, 7, 0, 525035869, 6, 7, 5, 3, -1193082762, 0 };

    static int[] a1 = { 6, -412046213, 1299128149, 1, -2097719512, -751291466, 0, 0, 0, 0 };

    static int[] a2 = { 8, 0, 0, 1986727496, 7, -1812906078, 9, 0, 0, 4 };

    int[] test_mula(int[] a0, int[] a1, int[] a2) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (int) (a1[i] * a2[i]);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12959().test_mula(a0, a1, a2);
    }
}
