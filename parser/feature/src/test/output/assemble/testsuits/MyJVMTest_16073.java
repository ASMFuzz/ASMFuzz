public class MyJVMTest_16073 {

    static int[] a0 = { 5, -1541114189, 0, 2, 5, 9, 2, 0, 0, 950395942 };

    static int[] a1 = { 5, 6, 8, -632092751, 0, -1498464075, -1041177295, 3, -1016399411, 9 };

    static int VALUE = 15;

    int[] test_srlc(int[] a0, int[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (int) (a1[i] >>> VALUE);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16073().test_srlc(a0, a1);
    }
}
