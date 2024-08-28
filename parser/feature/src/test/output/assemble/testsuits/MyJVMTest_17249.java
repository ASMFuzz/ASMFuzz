public class MyJVMTest_17249 {

    static int[] a0 = { 567021073, 0, -1919028979, 0, -864407093, 1, 2, 0, 1, 8 };

    static int[] a1 = { 6, 0, 0, 6, 8, 0, 4, 0, 8, 5 };

    static int SHIFT = 32;

    int[] test_sllc_on(int[] a0, int[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (int) (a1[i] << (-SHIFT));
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17249().test_sllc_on(a0, a1);
    }
}
