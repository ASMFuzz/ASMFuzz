public class MyJVMTest_7697 {

    static int[] a0 = { 7, 6, 3, 0, -957452752, 0, 4, 1275066683, 0, 0 };

    static int[] a1 = { 3, 5, 6, -1697312042, -1190278575, -1790021233, 8, 2, 1488901806, 845970679 };

    static int SHIFT = 32;

    int[] test_sllc_on(int[] a0, int[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (int) (a1[i] << (-SHIFT));
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7697().test_sllc_on(a0, a1);
    }
}
