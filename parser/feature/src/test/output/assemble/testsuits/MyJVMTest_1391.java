public class MyJVMTest_1391 {

    static int[] a0 = { 0, 0, 0, 0, 1630725314, 776272469, 1, 0, 8, 1 };

    static int[] a1 = { 2, 6, 9, 1620093064, 9, 3, 0, 0, 3, 5 };

    static int BIT_MASK = 0xEC80F731;

    int[] test_xorc(int[] a0, int[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (int) (a1[i] ^ BIT_MASK);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1391().test_xorc(a0, a1);
    }
}
