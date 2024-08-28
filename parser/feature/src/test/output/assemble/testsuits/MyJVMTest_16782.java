public class MyJVMTest_16782 {

    static int[] a0 = { 1930632982, 2, 0, 0, 0, 3, -1524746131, 1953692214, 7, 0 };

    static int[] a1 = { 0, 3, 4, 6, 0, 4, 0, 3, 0, 0 };

    static int[] a2 = { 5, 3, 1, 314501015, 1567455328, 3, 4, 7, 1889736224, 2 };

    int[] test_diva(int[] a0, int[] a1, int[] a2) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (int) (a1[i] / a2[i]);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16782().test_diva(a0, a1, a2);
    }
}
