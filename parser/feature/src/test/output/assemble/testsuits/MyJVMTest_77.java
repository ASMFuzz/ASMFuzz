public class MyJVMTest_77 {

    static int[] a0 = { 0, 0, 6, 2, 8, 6, -854258993, 0, 6, 3 };

    static int[] a1 = { 1898399862, 8, 6, 1, 0, 1, 498522768, 0, 0, 3 };

    static int[] a2 = { 6, 656605361, 0, 1664969817, -1161361635, 0, 699399010, 0, 3, 0 };

    int[] test_xora(int[] a0, int[] a1, int[] a2) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (int) (a1[i] ^ a2[i]);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_77().test_xora(a0, a1, a2);
    }
}
