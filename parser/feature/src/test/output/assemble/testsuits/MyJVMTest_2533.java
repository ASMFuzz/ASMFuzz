public class MyJVMTest_2533 {

    static int[] a0 = { 0, 0, 4, 1, 808793081, 0, 1, 9, 4, 6 };

    static int[] a1 = { 0, 0, 1, 3, 8, 0, 0, 3, 8, 2 };

    static int b = -76660429;

    int[] test_divv(int[] a0, int[] a1, int b) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (int) (a1[i] / b);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2533().test_divv(a0, a1, b);
    }
}
