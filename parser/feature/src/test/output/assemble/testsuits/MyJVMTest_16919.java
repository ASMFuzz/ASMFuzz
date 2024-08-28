public class MyJVMTest_16919 {

    static int[] a0 = { 1571496880, 4, 9, 0, 0, 907563073, 379540499, 9, 0, 8 };

    static int[] a1 = { 5, 1344505135, 0, 0, 3, 9, 1, 0, 1, 0 };

    static int b = 9;

    int[] test_andv(int[] a0, int[] a1, int b) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (int) (a1[i] & b);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16919().test_andv(a0, a1, b);
    }
}
