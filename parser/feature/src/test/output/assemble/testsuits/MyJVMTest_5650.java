public class MyJVMTest_5650 {

    static int[] a0 = { 3, 6, 282587426, 1713382088, -767048712, 622735470, 6, 1628054888, 0, -263604678 };

    static int[] a1 = { 0, 1, 5, 0, 0, 0, 8, -2038547309, -1483394801, 0 };

    static int SHIFT = 32;

    int[] test_srlc_o(int[] a0, int[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (int) (a1[i] >>> SHIFT);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5650().test_srlc_o(a0, a1);
    }
}
