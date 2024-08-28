public class MyJVMTest_10401 {

    static int[] a0 = { 149086695, 8, 2, 0, 0, 0, -1180530100, -1285138258, 9, 4 };

    static int[] a1 = { 1552196618, 3, 1809606236, 7, 8, 5, 1237599822, 5, 7, 0 };

    static int b = 0;

    int[] test_subv(int[] a0, int[] a1, int b) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (int) (a1[i] - b);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10401().test_subv(a0, a1, b);
    }
}
