public class MyJVMTest_16250 {

    static int[] a0 = { 9, 8, 6, 279998676, 340676182, 266345954, 9, 9, 5, 1 };

    static int[] a1 = { 2, 1, 6, 0, 0, 0, 6, 9, 1115735083, 0 };

    static int b = -1006655187;

    int[] test_sllv(int[] a0, int[] a1, int b) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (int) (a1[i] << b);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16250().test_sllv(a0, a1, b);
    }
}
