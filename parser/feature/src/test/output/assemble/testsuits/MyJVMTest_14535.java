public class MyJVMTest_14535 {

    static int[] a0 = { 3, 9, 744453110, -2115066581, 8, 0, 0, -516528271, 0, -1684113811 };

    static int[] a1 = { 1, 0, 4, 9, 9, 1329552206, 4, 6, 0, 8 };

    static int VALUE = 15;

    int[] test_sllc(int[] a0, int[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (int) (a1[i] << VALUE);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14535().test_sllc(a0, a1);
    }
}
