public class MyJVMTest_2719 {

    static int[] a0 = { 1175874724, 0, 8, 5, 2, 198227964, 0, 10975820, 4, 703537360 };

    static int[] a1 = { 0, 6, -602897348, 2, 0, 6, 1193785120, 8, 9, 1779586508 };

    static int VALUE = 15;

    int[] test_srac_n(int[] a0, int[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (int) (a1[i] >> (-VALUE));
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2719().test_srac_n(a0, a1);
    }
}
