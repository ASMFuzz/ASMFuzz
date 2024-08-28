public class MyJVMTest_16264 {

    static int[] a0 = { 1504003490, 1, 1, -1929788256, 7, 5, 0, 0, 0, -449070002 };

    static int[] a1 = { -1349871896, 2, 0, 5, 0, -768816781, -408850597, -1485234721, 870092883, 6 };

    static int SHIFT = 32;

    int[] test_srac_o(int[] a0, int[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (int) (a1[i] >> SHIFT);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16264().test_srac_o(a0, a1);
    }
}
