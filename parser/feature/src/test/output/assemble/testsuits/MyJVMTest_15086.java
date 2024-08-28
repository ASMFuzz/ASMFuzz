public class MyJVMTest_15086 {

    static int[] a0 = { 0, -1560305616, 4, 1, 0, 0, -1741874302, -987289342, 1991114584, 7 };

    static int[] a1 = { 2068100998, 0, 1000061578, 0, 3, 1, 1, 455700060, -2027334512, 0 };

    static int SHIFT = 32;

    int[] test_srlc_o(int[] a0, int[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (int) (a1[i] >>> SHIFT);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15086().test_srlc_o(a0, a1);
    }
}
