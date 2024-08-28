public class MyJVMTest_12121 {

    static int[] a0 = { 1141112576, -1794356665, 0, 2, -770541666, 4, 0, 1, 8, -1277504848 };

    static int[] a1 = { 8, 2, 0, 0, 6, -1225760567, -1626704563, 7, 0, 0 };

    static int SHIFT = 32;

    int[] test_srlc_on(int[] a0, int[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (int) (a1[i] >>> (-SHIFT));
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12121().test_srlc_on(a0, a1);
    }
}
