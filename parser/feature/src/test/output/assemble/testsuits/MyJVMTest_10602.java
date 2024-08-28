public class MyJVMTest_10602 {

    static int[] a0 = { 9, -512439830, 5, 5, 1, 3, 6, 1, 0, 1 };

    static int[] a1 = { 434930720, 1684987913, 1, 9, 8, 0, 0, 7, 8, 0 };

    static int BIT_MASK = 0xEC80F731;

    int[] test_xorc(int[] a0, int[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (int) (a1[i] ^ BIT_MASK);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10602().test_xorc(a0, a1);
    }
}
