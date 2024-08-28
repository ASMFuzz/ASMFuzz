public class MyJVMTest_1045 {

    static int[] a0 = { 2, 0, -661544416, 0, -2023451658, 5, 0, 308247094, 0, 0 };

    static int[] a1 = { 9, 636246331, -849073528, 558804796, 806126386, -1905342301, 0, 432809468, 0, 8 };

    static int BIT_MASK = 0xEC80F731;

    int[] test_orc(int[] a0, int[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (int) (a1[i] | BIT_MASK);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1045().test_orc(a0, a1);
    }
}
