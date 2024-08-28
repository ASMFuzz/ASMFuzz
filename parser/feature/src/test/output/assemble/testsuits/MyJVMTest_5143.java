public class MyJVMTest_5143 {

    static int[] a0 = { -1338564915, 0, 8, 9, 7, 1889470617, 0, 909313040, 5, -1406239421 };

    static int[] a1 = { 0, 0, 9, 0, 0, -775466078, -276938970, 0, 7, 0 };

    static int VALUE = 15;

    int[] test_sllc_n(int[] a0, int[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (int) (a1[i] << (-VALUE));
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5143().test_sllc_n(a0, a1);
    }
}
