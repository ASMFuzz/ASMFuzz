public class MyJVMTest_6767 {

    static int[] a0 = { 2, 0, 9, 109663845, 5, 1633089647, 0, 0, 0, 8 };

    static int[] a1 = { 9, 7, 6, 0, 0, 0, 0, 3, 0, 0 };

    static int SHIFT = 32;

    int[] test_srac_o(int[] a0, int[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (int) (a1[i] >> SHIFT);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6767().test_srac_o(a0, a1);
    }
}
