public class MyJVMTest_11807 {

    static int[] a0 = { 1, 0, 0, 0, 2072022428, 1, 7, 3, 1162984646, 8 };

    static int[] a1 = { 7, 0, 0, 0, 0, 4, 0, 3, 8, 0 };

    static int b = 0;

    int[] test_divv(int[] a0, int[] a1, int b) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (int) (a1[i] / b);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11807().test_divv(a0, a1, b);
    }
}
